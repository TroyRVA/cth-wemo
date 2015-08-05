package com.hackathon.app;

import com.palominolabs.wemo.InsightSwitch;
import com.palominolabs.wemo.InsightSwitchFinder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        String switchFriendlyName = "OneMo";
        try (InsightSwitchFinder insightSwitchFinder = new InsightSwitchFinder(switchFriendlyName)) {
            if (!insightSwitchFinder.findSwitches()) {
                throw new IllegalStateException("Unable to find switches");
            }

            InsightSwitch insightSwitch = insightSwitchFinder.getSwitch(switchFriendlyName);

            while (true) {
                insightSwitch.switchOn();
                Thread.sleep(100);
                insightSwitch.switchOff();
                Thread.sleep(100);
            }
        
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
    }
}
