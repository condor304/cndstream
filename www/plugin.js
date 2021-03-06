
var exec = require('cordova/exec');

var PLUGIN_NAME = 'cndStream';

var cndStream = {
  stop: function( cb) {
    exec(cb, null, PLUGIN_NAME, 'stop',[]);
  },
   pause: function(cb) {
    exec(cb, null, PLUGIN_NAME, 'pause',[]);
  },

     reset: function(cb) {
    exec(cb, null, PLUGIN_NAME, 'reset',[]);
  },
 
  play: function(videoLink, cb){

 exec(cb, null, PLUGIN_NAME, 'play', [videoLink]);

  }
};

module.exports = cndStream;
