public class Warrior extends baseChar {
    
    public Warrior(String name) {
	setName(name);
	setHealth(100);
	setStrength(20);
	setPrecision(7);
    }

    public String slash(baseChar other) {
	if (canHit(getPrecision() - 1)) {
	    int damage = getStrength() + 10;
	    other.setHealth(other.getHealth() - damage);
	    return this + " slashes at " + other;
	} else {
	    return (this + " slashes at " + other + " and misses");
	}
    }
    
    public String longSlash(baseChar other) {
	if (canHit(getPrecision() - 3)) {
	    int damage = getStrength() + 30;
	    other.setHealth(other.getHealth() - damage);
	    return this + " long slashes at " + other;
	} else {
	    return (this + " long slashes at " + other + " and misses");
	}
    }

}
