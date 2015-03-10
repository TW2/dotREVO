/*
 * Copyright (C) 2015 Phil
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
