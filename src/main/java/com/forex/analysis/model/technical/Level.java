package com.forex.analysis.model.technical;

import java.io.Serializable;

import com.forex.analysis.constant.LevelType;

/**
 * This class represents a support / resistance level.
 *  
 */
public class Level implements Serializable {

    private static final long serialVersionUID = -7561265699198045328L;

    private LevelType type;

    private Float level, strength;

    public Level(final LevelType type, final Float level) {
        this(type, level, 0f);
    }

    public Level(final LevelType type, final Float level, final Float strength) {
        super();
        this.type = type;
        this.level = level;
        this.strength = strength;
    }


    @Override
    public String toString() {
        return "Level [type=" + this.type + ", level=" + this.level
                + ", strength=" + this.strength + "]";
    }

	public LevelType getType() {
		return type;
	}

	public Float getLevel() {
		return level;
	}

	public Float getStrength() {
		return strength;
	}

	public void setType(LevelType type) {
		this.type = type;
	}

	public void setLevel(Float level) {
		this.level = level;
	}

	public void setStrength(Float strength) {
		this.strength = strength;
	}

}