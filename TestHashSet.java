package CollectionPrac;

import java.util.HashSet;

public class TestHashSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Object> hs=new HashSet<Object>();
		System.out.print(hs.size());   System.out.println("\t"+hs); //0	[]
		System.out.print(hs.add("a"));   System.out.println("\t"+hs);//true	[a]
		System.out.print(hs.add("b")); System.out.print(" "+hs.size());  System.out.println("\t"+hs);//true 2	[a, b]
		System.out.print(hs.add(5));   System.out.println("\t"+hs);//true	[a, b, 5]
		System.out.print(hs.add(6.7));   System.out.println("\t"+hs);//true	[a, b, 5, 6.7]
		System.out.print(hs.add(97));   System.out.println("\t"+hs);//true	[a, 97, b, 5, 6.7]
		//a and 97 is store in one bucket because 'a'->97%16=1 and 97%16=1 both are same index hash code
		//formula for storing data in HS current object into IISIC like "a"->97%16 is capacity =1 
		//so a is stored in 1 index 
		//internally HS is 3 thing 
		//1. hashCode() 2. == 3. equals()
		// 1. hashCode() for creating same hash code as one group
		//2. == operator compare new object hash code as one group hash code 
		// 3. equals() is compared content is available or not
		//if after 3 thing return false HashSet element not add object 
		//then return true object is added in hash table
		System.out.print(hs.add(true));   System.out.println("\t"+hs);//true	[a, 97, b, 5, 6.7, true]
		//true add as string like (String(true)) and compare then add
		System.out.print(hs.add('p'));   System.out.println("\t"+hs);//true	[p, a, 97, b, 5, 6.7, true]
		//'p' as 112%16=0 it added at 0 index
		
		System.out.print(hs.add(null));   System.out.println("\t"+hs); //true	[p, null, a, 97, b, 5, 6.7, true]
		// null is at 0 index so 'p' and null is stored in one bucket 0 index
		System.out.print(hs.add("a"));   System.out.println("\t"+hs); //false	[p, null, a, 97, b, 5, 6.7, true]
       // "a" is not added because already available in HashSet not allowed duplicate
		
		System.out.print(hs.add(false));   System.out.println("\t"+hs);// true	[p, null, a, 97, b, 5, false, 6.7, true]
		System.out.print(hs.add(new String("a")));   System.out.println("\t"+hs);//false	[p, null, a, 97, b, 5, false, 6.7, true]
		System.out.println(hs.size()); // 9
		// new String("a") is not added because already available in HashSet 
		
		System.out.print(hs.add(new Sa(5,6)));   System.out.println("\t"+hs);//true	[p, null, a, 97, b, 5, false, 6.7, Sa( 5,6), true]
		//Sa(5,6) stored based on reference reference%16=> not overridden hashCode() in Sa class
		System.out.print(hs.add(new Sa(5,6)));   System.out.println("\t"+hs);
		//Sa(5,6) stored another location based on reference reference%16=> not overridden hashCode() in Sa class
		
		System.out.print(hs.add(new Ex(5,6)));   System.out.println("\t"+hs);//true	[p, null, a, 97, b, Sa( 5,6), 5, false, 6.7, Ex( 5,6), Sa( 5,6), true]
		//Ex(5,6) is stored in new bucket because hashCode() is Overridden in Ex class and it return x+y (5+6=11);bucket no is 11 not stored depend reference
		System.out.print(hs.add(new Ex(5,6)));   System.out.println("\t"+hs);//true	[null, a, 97, b, 5, Ex( 5,6), Ex( 5,6), true, p, Sa( 5,6), false, 6.7, Sa( 5,6)]
		//Ex(5,6) is stored in same bucket above line because hashCode() is Overridden in Ex class and it return x+y; bucket no is 11
		System.out.print(hs.add(10L));  System.out.println("\t"+hs);//true	[null, a, 97, b, 5, 10, Ex( 5,6), Ex( 5,6), true, p, Sa( 5,6), false, 6.7, Sa( 5,6)]
		//is stored at 10 before Ex(5,6) 5+6=11 at 11 
		System.out.println(hs.size());//14
		System.out.print(hs.add(98));  System.out.println("\t"+hs);
		System.out.print(hs.add(11));  System.out.println("\t"+hs);
		System.out.println(hs.size());//16 capacity will full and change into 32
 		// if the size reach to capacity the hash table is rerArrangent the all elements chage capacity 16 to 32 rerArrangent is called rehashing
	/*
	 Linked hahsSet is functionality wise no difference 
	 * HashSet does not store unique object in insertion order 
	 * Linked hashSet stored unique object in insertion order
	 * LinkedHashSet also used hash table with Bucket data Structure
	 * in addition two has table it also use doubly linked list data structure for maintaining insertion order
	 * LHS Data structure is [hash table + doubly linked list]
	 */
	
	}

}
