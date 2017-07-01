package htw.designpattern.projekt.proxy.dismissed;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class klasse1 {
	
    Object [][] test;
	
	@Override
	public String toString() {
		return "klasse1 [test=" + test + "]";
	}

	public klasse1() {
		test = new Object [2][1];
		 test[0][0] = "Miriam";
		 test[1][0] = "hat geplapt";

		
	}

}
