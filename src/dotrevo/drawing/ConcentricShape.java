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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Phil
 */
public class ConcentricShape {

    private String name = "Shape";
    private float rotation = 0f;
    //Pourcentage représentant l'espacement à partir du centre
    //0% = point du centre
    //100% = ligne extérieure
    private float percent = 0f; //0 = 0% ; 1 = 100%
    private Color fill = Color.red;
    
    private List<AShape> parents = new ArrayList<>();
    
    public ConcentricShape() {
        
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
    
    public void setRotation(float rotation){
        this.rotation = rotation;
    }
    
    public float getRotation(){
        return rotation;
    }
    
    public void setPercent(float percent){
        this.percent = percent;
    }
    
    public float getPercent(){
        return percent;
    }
    
    public void setColor(Color fill){
        this.fill = fill;
    }
    
    public Color getColor(){
        return fill;
    }
    
    public void setParents(List<AShape> parents){
        this.parents = parents;
    }
    
    public List<AShape> getParents(){
        return parents;
    }
}
