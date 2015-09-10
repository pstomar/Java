
/*      Encapsulation : -
 *
 *      Encapsulation is a process to hide data from outer world
 *      and keep object in valid mode.
 *
 *
 *
 */

class Bulb {
    private int w;
    public void setWattage(int e)
    {
        if(e>0 && e<=240){
            w=e;
        }else {
            w = 0;
        }
    }
    public int getWattage(){
        return w;
    }
}

class psp{
	public static void main(String gg[]) {
        Bulb b;
        b = new Bulb();
        b.setWattage(-30);
        System.out.println("Wattage is "+b.getWattage());
        Bulb k;
        k= new Bulb();
        b.setWattage(100);
        System.out.println("Wattage is "+k.getWattage());
        Bulb r;
        r=null;
        System.out.println("blah blah 1");
        r.setWattage(r.getWattage());       //app get crashed here
        System.out.println("blah blah 2");
	}
}
