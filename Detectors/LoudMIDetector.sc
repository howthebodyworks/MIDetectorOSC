LoudMIDetector : MIDetector{
	
	*new{|win,in=0,tag=0,args=nil|
		^super.newCopyArgs(win,in,tag,args).init();	
	}	
	
	init {
		this.initValues();
		super.init();
		this.loadSynthDef();
		super.makeGenericGui();
		this.makeSpecificGui();
	}

	initValues {
		//create default values if not present
		if(args.isNil,{args=[]});
		this.checkArg(\mult,1.0);
		name="Loud";
		nBus=1;
		bus=Bus.control(Server.default,nBus);	
		value=0;
	}

	loadSynthDef {
		synthname=name++"MIDetect";
		SynthDef(synthname,{|in=0,gate=1,bus,mult=1|
			var sig,loud,chain;
			sig=InFeedback.ar(in);
			chain = FFT(LocalBuf(2048,1), sig);
			loud=Loudness.kr(chain);
			Out.kr(bus,loud*mult)
		}).load(Server.default);
	}

	makeSpecificGui {
		this.addBasicSlider(\mult,[0.01,100,\exp,0.01].asSpec);
		controls.put(\show,NumberBox(win,45@18));
		win.setInnerExtent(win.bounds.width,win.bounds.height+24);
	}
	
	detect {|net|
		bus.get({|val|
			val=(val-0.19); //silence
			if(verbose){format("% :  % ",name,val).postln};
			{controls[\show].value_(val.round(0.01))}.defer;
			net.sendMsg(oscstr,tag,val);
		}
		);	
		
	}
	
	
}