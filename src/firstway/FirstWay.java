/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstway;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Reaz
 */
public class FirstWay {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        LoadingPage lod=new LoadingPage();
        lod.setVisible(true);
        try{
            for(int i=0; i<=100; i++){
                Thread.sleep(20);
                LoginPage log=new LoginPage();
                if(i==70){
                    lod.dispose();
                    log.show();
                }
            }
        
        }catch(Exception ee){
        
        }
    }
    
}
