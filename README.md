cndStream 
======

This is a simple plugin to play audio from HLS m3u8 playlists on both iOS and Android.


install: cordova plugin add https://github.com/condor304/cndstream.git

Usage:

Play:

window.cndStream.play("YOUR URL")

Pause:

window.cndStream.pause();

Stop:

window.cndStream.stop();

Reset:

window.cndStream.reset();


NOTE: it works only on device or simulator - not on browser