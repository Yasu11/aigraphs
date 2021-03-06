package de.pxbox.aingraphs.visual;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

import de.pxbox.aingraphs.graph.AStarPathfinder;

public class InformationPanel extends Table{

	int mode = -1;
	ArrayList<Label> labels;
	AStarPathfinder pf;
	
	
	public InformationPanel(Skin skin,AStarPathfinder pf) {
		labels = new ArrayList<Label>(0);
		this.pf = pf;
		labels.add(new Label("Modus : ", skin));
		labels.add(new Label(getMode(), skin));
		labels.add(new Label("Typ : ", skin));
		labels.add(new Label("A*-Suche", skin));
		labels.add(new Label("Laenge : ", skin));
		labels.add(new Label("0 m", skin));
		
		setMode(0);

		for(int i = 0; i < labels.size();i+=2){
			this.add(labels.get(0+i)).right().uniform().space(5).padLeft(10);
			this.add(labels.get(1+i)).left().expandX().space(5).row();
		}
		
//		this.debug();
		this.pack();
	}
	
	public void setMode(int mode){
		this.mode = mode;
		
	}
	
	public void update(){
		labels.get(1).setText(getMode());
		labels.get(5).setText(pf.getLength() + " m");
	}

	public String getMode(){
		switch(mode){
		case 0:
			return "Knoten";
		case 1:
			return "Verbindungen";
		case 2:
			return "Wegfindung";
		case -1:
			return "############";
		default:
			return "";
		}
	}
	
	@Override
	public void draw(Batch batch, float parentAlpha) {
		update();
		super.draw(batch, parentAlpha);
	}
	
	
}
