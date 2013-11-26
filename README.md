MIDetectorOSC
=============
*Last tested on SuperCollider 3.6.5 on Ubuntu 13.04, Requires SC3-plugins installed (http://sourceforge.net/projects/sc3-plugins/).*


Supercollider extension Quark-wannabe for relaying Music Information via OSC.
The main motivation behind this quark is to have connect visual interactions with sound interactions via OSC Messaging.
Ideally you would run the detector in SC and relay the info to your favorite program like Processing, OF, Cinder, etc.


How to install as a Quark
-------------------------

1.  Clone to the to the Supercollider/quarks folder, typically this is
  * Linux:  ~/.local/share/SuperCollider/
  * MacOSX: ~/Library/Application\ Support/SuperCollider/
  * Windows: C:\Users\UserName\SuperCollider\

  So this would be...

    <pre><code>cd folder
    git clone https://github.com/beangoben/MIDetectorOSC.git
    </code></pre>
    
2.  Copy MIDetectorOSC.quark to the Supercollider/quarks/DIRECTORY folder.
3.  You can now install via Quarks.gui.
4.  Checkout the MIDetectorOSC guide/overview helpfile.


How to install as an Extension
-------------------------

Just copy to your Supercollider/Extensions folder.


Wish/Todo-list:
-------------------------
* Onset detection + BandPass filtering needs some work.
* Fix multiple onset detectors bug (might be LocalBuf?).
* More detectors: FFT Centroids, Chromagrams, Mel coefficients.
* Make awesome documentation and examples with processing.
* Calculate statistical info like medians, max,min, averages and variance.

Want to contribute with code? Have any Ideas? Problems?
-------------------------
Sendme an email!  beangoben@gmail.com


