package tutorials.tutorial_3;

import tutorials.tutorial_12.*;
import static utils.DomainConstraint.ZERO_PLUS;

import utils.AttrRef;
import utils.DOpt;
import utils.DomainConstraint;
import utils.NotPossibleException;
import utils.OptType;

/**
 * @overview Vehicle is a device that is designed or used to transport people or
 *           cargo over land, water, air, or through space.
 * @attributes
 *  name    String
 *  width   Double
 *  height  Double
 *  length  Double
 *  weight  Double
 *  seatingCapacity Integer
 *  registrationNumber String
 * @object
 *  A typical Vehicle is <pre>v = < n,d,h,l,w,c ></pre>, where
 *    <pre>name(n), width(d), height(h), length(l), weight(w), seatingCapacity(c)</pre>
 * @abstract_properties
 *    mutable(name)=true /\ optional(name)=false /\ 
 *    mutable(width)=true /\ optional(width)=false /\ min(width)=0+ /\
 *    mutable(height)=true /\ optional(height)=false /\ min(height)=0+ /\ 
 *    mutable(length)=true /\ optional(length)=false /\ min(length)=0+ /\
 *    mutable(weight)=true /\ optional(weight)=false /\ min(weight)=0+ /\ 
 *    mutable(seatingCapacity)=true /\ optional(seatingCapacity)=false /\ min(seatingCapacity)=1 /\ 
 * mutable(registrationNumber)=true /\ optional(registrationNumber)= false /\ 
 * @author dmle
 */
public class Vehicle {

    @DomainConstraint(type = "String", optional = false)
    private String name;
    @DomainConstraint(type = "Double", min = ZERO_PLUS, optional = false)
    private double width;
    @DomainConstraint(type = "Double", min = ZERO_PLUS, optional = false)
    private double height;
    @DomainConstraint(type = "Double", min = ZERO_PLUS, optional = false)
    private double length;
    @DomainConstraint(type = "Double", min = ZERO_PLUS, optional = false)
    private double weight;
    @DomainConstraint(type = "Integer", min = 1, optional = false)
    private int seatingCapacity;
    @DomainConstraint(type = "Integer", optional = false)
    private String registrationNumber;

    // constructor methods
    /**
     * @effects <pre>
     *            if n, d, h, l, w, c, r are valid
     *              initialise this as Vehicle:<n,d,h,l,w,c,r >
     *            else
     *              print error message
     *          </pre>
     */
    public Vehicle(@AttrRef("name") String n,
            @AttrRef("width") double d, @AttrRef("height") double h, @AttrRef("length") double l,
            @AttrRef("weight") double w, @AttrRef("seatingCapacity") int c,
            @AttrRef("registrationNumber") String r) throws NotPossibleException {
        try {
            if (validate(n, d, h, l, w, c, r)) {
                name = n;
                width = d;
                height = h;
                length = l;
                weight = w;
                seatingCapacity = c;
                registrationNumber = r;
            } else {
                throw new NotPossibleException("Vehicle<init>: invalid arguments");
            }
        } catch (Exception e) {
            System.out.println("Vehicle<init>: invalid arguments");
        }

    }

    // methods
    /**
     * @effects return <tt>this.name</tt>
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("name")
    public String getName() {
        return name;
    }

    /**
     * @effects <pre>
     *            if name is valid
     *              set this.name = name
     *            else
     *              throws NotPossibleException</pre>
     */
    @DOpt(type = OptType.Mutator)
    @AttrRef("name")
    public void setName(String name) throws NotPossibleException {
        try {
            if (validateName(name)) {
                this.name = name;
            } else {
                System.err.println("Vehicle.setName: invalid name: " + name);
            }
        } catch (Exception e) {
            throw new NotPossibleException("Vehicle.setName: invalid name: " + name);

        }

    }

    /**
     * @effects return <tt>this.width</tt>
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("width")
    public double getWidth() {
        return width;
    }

    /**
     * @effects <pre>
     *            if width is valid
     *              set this.width = width
     *            else 
     *              print error message</pre>
     */
    @DOpt(type = OptType.Mutator)
    @AttrRef("width")
    public void setWidth(double width) throws NotPossibleException {
        if (validateDimension(width)) {
            this.width = width;
        } else {
            throw new NotPossibleException("Vehicle.setWidth: invalid width " + width);
        }

    }

    /**
     * @effects return <tt>this.height</tt>
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("height")
    public double getHeight() {
        return height;
    }

    /**
     * @effects <pre>
     *            if height is valid
     *              set this.height = height
     *            else 
     *              print error message
     */
    @DOpt(type = OptType.Mutator)
    @AttrRef("height")
    public void setHeight(double height) throws NotPossibleException {
        if (validateDimension(height)) {
            this.height = height;
        } else {
            throw new NotPossibleException("Vehicle.setHeight: invalid height: " + height);
        }

    }

    /**
     * @effects return <tt>this.length</tt>
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("length")
    public double getLength() {
        return length;
    }

    /**
     * @effects <pre>
     *            if length is valid
     *              set this.length = length
     *            else
     *              print error message 
     */
    @DOpt(type = OptType.Mutator)
    @AttrRef("length")
    public void setLength(double length) throws NotPossibleException {

        if (validateDimension(length)) {
            this.length = length;
        } else {
            throw new NotPossibleException("Vehicle.setLength: invalid length " + length);

        }

    }

    /**
     * @effects return <tt>this.weight</tt>
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("weight")
    public double getWeight() {
        return weight;
    }

    /**
     * @effects <pre>
     *            if weight is valid
     *              set this.weight = weight
     *            else 
     *              print error message
     */
    @DOpt(type = OptType.Mutator)
    @AttrRef("weight")
    public void setWeight(double weight) throws NotPossibleException {
        if (validateWeight(weight)) {
            this.weight = weight;
        } else {
            throw new NotPossibleException("Vehicle.setWeight: invalid weight: " + weight);
        }
    }

    /**
     * @effects return <tt>this.seatingCapacity</tt>
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("seatingCapacity")
    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    /**
     * @effects <pre>
     *            if seatingCapacity is valid
     *              sets this.seatingCapacity = seatingCapacity
     *            else 
     *              throws NotPossibleException</pre>
     */
    @DOpt(type = OptType.Mutator)
    @AttrRef("seatingCapacity")
    public void setSeatingCapacity(int seatingCapacity) throws NotPossibleException {
        if (validateSeatingCapacity(seatingCapacity)) {
            this.seatingCapacity = seatingCapacity;
        } else {
            throw new NotPossibleException("Vechile.setSeatingCapacity: invalid seating " + seatingCapacity);
        }
    }

    /**
     * @effects return <tt>this.registrationNumber</tt>
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("registrationNumber")
    public String getRegisterationNumber() {
        return registrationNumber;
    }

    /**
     * @effects <pre>
     *            if registrationNumber is valid
     *              sets this.registrationNumber = registrationNumber
     *            else 
     *              throws NotPossibleException</pre>
     */
    @DOpt(type = OptType.Mutator)
    @AttrRef("seatingCapacity")
    public void setRegisterationNumber(String registerNumber) {
        if (validateRegisterNumber(registerNumber)) {
            this.registrationNumber = registerNumber;
        } else {
            throw new NotPossibleException("Vechile.setSeatingCapacity: invalid registrationNumber " + seatingCapacity);
        }
    }

    /**
     * @effects return the total weight (in kilograms) as the sum of weight and
     *          the estimated passengers weight
     */
    public double calcTotalWeight() {
        // the estimated passenger weight is 50kgs
        double tw = weight + seatingCapacity * 50D;
        return tw;
    }

    /**
     * @effects <pre>
     *            if this satisfies rep invariant
     *              return true 
     *            else
     *              return false</pre>
     */
    public boolean repOK() {
        return validate(name, width, height, length, weight, seatingCapacity, registrationNumber);
    }

    @Override
    public String toString() {
        return "Vehicle(" + name + ")";
    }

    // validation methods
    /**
     * @effects <pre>
     *            if < n,d,h,l,w,c > is a valid tuple 
     *              return true
     *            else
     *              return false </pre>
     */
    private boolean validate(String n, double d, double h, double l, double w,
            int c, String r) {
        return validateName(n)
                && validateDimension(d) && validateDimension(h) && validateDimension(l)
                && validateWeight(w) && validateSeatingCapacity(c)
                && validateRegisterNumber(r);
    }

    /**
     * @effects <pre>
     *            if n is valid 
     *              return true 
     *            else 
     *              return false</pre> 
     */
    private boolean validateName(String n) {
        if (n == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * @effects <pre>
     *            if r is valid 
     *              return true 
     *            else 
     *              return false</pre> 
     */
    protected boolean validateRegisterNumber(String r) {
        if (r == null || r.length() == 0 || r.length() >= 10) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * @effects <pre>
     *            if v is a valid dimension
     *              return true 
     *            else 
     *              return false</pre> 
     */
    private boolean validateDimension(double v) {
        if (v <= 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * @effects <pre>
     *   if w is valid 
     *     return true 
     *   else 
     *     return false</pre> 
     */
    protected boolean validateWeight(double w) {
        if (w <= 0) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * @effects <pre>
     *            if c is valid 
     *              return true 
     *            else 
     *              return false</pre> 
     */
    protected boolean validateSeatingCapacity(int c) {
        if (c <= 0) {
            return false;
        } else {
            return true;
        }
    }
}
