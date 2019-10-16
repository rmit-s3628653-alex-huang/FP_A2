//Further Programming Assignment 1 by Alex Huang s3628653
package model;

import model.enumeration.Color;
import model.interfaces.Slot;

public class SlotImpl implements Slot {

	private int position;
	private Color color;
	private int number;

	public SlotImpl(int position, Color color, int number){
		this.position = position;
		this.color = color;
		this.number = number;
		
	}
	@Override
	public int getPosition() {
		return this.position;
	}

	@Override
	public int getNumber() {
		return this.number;
	}

	@Override
	public Color getColor() {
		return this.color;
	}

	@Override
	public boolean equals(Slot slot) {
		if (this.color == slot.getColor() && this.number == slot.getNumber()) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean equals(Object slot) {
		if(slot instanceof SlotImpl && this.equals(slot)) {
			return true;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + number;
		result = prime * result + position;
		return result;
	}
	
    @Override
    public String toString() {
        return String.format("Position: %d, Color: %s, Number: %d", this.position, this.color, this.number);
    }

}
