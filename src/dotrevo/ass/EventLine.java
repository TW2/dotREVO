/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dotrevo.ass;

/**
 *
 * @author Phil
 */
public class EventLine {
    
    String Type = "Dialogue";
    String Layer = "0";
    String Start = "0:00:00.00";
    String End = "0:00:00.00";
    String Style = "Default";
    String Name = "";
    String MarginL = "0000";
    String MarginR = "0000";
    String MarginV = "0000";
    String Effect = "";
    String Text = "";

    public EventLine(){

    }

    public static EventLine create(String rawline){
        EventLine ev = new EventLine();
        
        if(rawline.startsWith("Comment")){
            ev.Type = "Comment";
        }

        String newline = rawline.substring(rawline.indexOf(":")+1);
        String[] table = newline.split(",");

        ev.Layer = table[0];
        ev.Start = table[1];
        ev.End = table[2];
        ev.Style = table[3];
        ev.Name = table[4];
        ev.MarginL = table[5];
        ev.MarginR = table[6];
        ev.MarginV = table[7];
        ev.Effect = table[8];
        ev.Text = table[9];
        
        return ev;
    }

    public String getType(){
        return Type + ": ";
    }

    public String getLayer(){
        return Layer;
    }

    public String getStart(){
        return Start;
    }

    public String getEnd(){
        return End;
    }

    public String getStyle(){
        return Style;
    }

    public String getName(){
        return Name;
    }

    public String getMarginL(){
        return MarginL;
    }

    public String getMarginR(){
        return MarginR;
    }

    public String getMarginV(){
        return MarginV;
    }

    public String getEffect(){
        return Effect;
    }

    public String getText(){
        return Text;
    }
    
}
