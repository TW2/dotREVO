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
package dotrevo.drawing;

import java.awt.Color;

/**
 *
 * @author Phil
 */
public class Colors {
    
    public static Color getGradientColor(Color from, Color to, float percent){
        int r = (int)(from.getRed() * percent + to.getRed() * (1 - percent));
        int g = (int)(from.getGreen()* percent + to.getGreen()* (1 - percent));
        int b = (int)(from.getBlue()* percent + to.getBlue()* (1 - percent));
        int a = (int)(from.getAlpha()* percent + to.getAlpha()* (1 - percent));
        return new Color(r, g, b, a);
    }
    
}
