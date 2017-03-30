#import <Cordova/CDVPlugin.h>
#import <MediaPlayer/MediaPlayer.h>


@interface cndStream : CDVPlugin {

   
}
@property (nonatomic, strong)MPMoviePlayerController *moviePlayer;
// The hooks for our plugin commands

-(void)play:(CDVInvokedUrlCommand *)command;
-(void)stop:(CDVInvokedUrlCommand *)command;
-(void)pause:(CDVInvokedUrlCommand *)command;

@end
