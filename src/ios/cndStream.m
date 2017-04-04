#import "cndStream.h"

#import <Cordova/CDVAvailability.h>

@implementation cndStream

- (void)pluginInitialize {
}

- (void)echo:(CDVInvokedUrlCommand *)command {
  NSString* phrase = [command.arguments objectAtIndex:0];
  NSLog(@"%@", phrase);
}
-(void)preparePlayer:(NSString *)videoURL{
    NSURL *movieURL = [NSURL URLWithString:videoURL];
    MPMoviePlayerController *mp = [[MPMoviePlayerController alloc] initWithContentURL:movieURL];
    
    if (mp)
    {
        mp.view.frame = CGRectMake(0, 0, 0, 0);
       // [self.view addSubview:mp.view];
        
        // save the movie player object
        [mp setFullscreen:NO];
        
        // Play the movie!
        [mp play];
        
        self.moviePlayer = mp;
    }


    
}

-(void)reset:(CDVInvokedUrlCommand *)command {


    [self.moviePlayer stop];
    
}


-(void)play:(CDVInvokedUrlCommand *)command {
 NSString* videoUrl = [command.arguments objectAtIndex:0];
 if(self.moviePlayer.playbackState == MPMoviePlaybackStatePaused){
        
        [self.moviePlayer play];
    }
    else{
        
        
        [self preparePlayer:videoUrl];
    }

}

-(void)stop:(CDVInvokedUrlCommand *)command {
[self.moviePlayer stop];

}

-(void)pause:(CDVInvokedUrlCommand *)command {

 [self.moviePlayer pause];

}


// - (void)getDate:(CDVInvokedUrlCommand *)command {
//   NSDateFormatter *dateFormatter = [[NSDateFormatter alloc] init];
//   NSLocale *enUSPOSIXLocale = [NSLocale localeWithLocaleIdentifier:@"en_US_POSIX"];
//   [dateFormatter setLocale:enUSPOSIXLocale];
//   [dateFormatter setDateFormat:@"yyyy-MM-dd'T'HH:mm:ssZZZZZ"];

//   NSDate *now = [NSDate date];
//   NSString *iso8601String = [dateFormatter stringFromDate:now];

//   CDVPluginResult *result = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsString:iso8601String];
//   [self.commandDelegate sendPluginResult:result callbackId:command.callbackId];
// }

@end
