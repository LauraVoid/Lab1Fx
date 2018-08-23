package modelo;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Principal {

	private ArrayList<Double> numbers;
	private int rangeHigher;
	private int rangeLower;
	private int amountNumbers;

	public Principal() {
		numbers = new ArrayList<Double>();

	}
	
	

	public int getRangeHigher() {
		return rangeHigher;
	}



	public void setRangeHigher(int rangeHigher) {
		this.rangeHigher = rangeHigher;
	}



	public int getRangeLower() {
		return rangeLower;
	}



	public void setRangeLower(int rangeLower) {
		this.rangeLower = rangeLower;
	}



	public int getAmountNumbers() {
		return amountNumbers;
	}



	public void setAmountNumbers(int amountNumbers) {
		this.amountNumbers = amountNumbers;
	}



	public void setNumbers(String cadena) {

		String[] givenNumbers = cadena.split(",");

		for (int i = 0; i < givenNumbers.length; i++) {
			numbers.add(Double.valueOf(givenNumbers[i]));

		}

	}
	
	
	public ArrayList<Double> getNumbers() {
		return numbers;
	}

	public int calculatePercent(int amountData, int percent) {
		
		return (int)((amountData *percent)/100);
	}
	public ArrayList<Double> changeNumbers(ArrayList<Double> numbers,int amountData, int percent) {
		InsertionUp(numbers);
		int totalMess = calculatePercent(amountData, percent);
		int half=totalMess/2;
		double current=0;
		for(int i =0;i<totalMess-1;i+=2) {
			current = numbers.get(i);
			numbers.set(i, numbers.get(i+1));
			numbers.set(i+1, current);
		}
		return numbers;
		
	}
	
	public ArrayList<Double> randomInt(int amount, boolean repeated, int LowerIndex, int HighIndex) {
		
		ArrayList<Double> array = new ArrayList<Double>();
		double current=0;
		for (int i = 0; i < amount; i++) {
			
			 current = ThreadLocalRandom.current().nextInt(LowerIndex, HighIndex + 1);
			 if(!repeated) {
			 if (!isRepeated(array, current)) {
				 array.add(current);
		        }
			 else {
				 current = ThreadLocalRandom.current().nextInt(LowerIndex, HighIndex + 1);
				 array.add(current);
				 
			        
			 }
			 
			 }else {
				 array.add(current);
			 }
		
			 
		}
			
		return array;
	}
			 
		public boolean isRepeated(ArrayList<Double> array, double num) {
			    boolean repeated = false;
			    for (int i = 0; i < array.size(); i++) {
			        if (array.get(i) == num) {
			        	repeated = true;
			        } 
			    }
			    return repeated;
			}
	public double randomGenerate(int amount) {
		
		double random=((Math.random()*50)+1);
		System.out.println("este");
		return random;
	}
	
	public ArrayList<Double> InsertionUp(ArrayList<Double> numbers) {
		for(int i=1; i<numbers.size();i++) {
			for(int j=i; j>0&& numbers.get(j-1)>numbers.get(j); j--) {
				
				double temp= numbers.get(j);
				numbers.set(j, numbers.get(j-1));
				numbers.set(j-1, temp);
				
			}
		}
		return numbers;
	}
	
	public float[] Insercion(float[] arreglo) {
		for(int i=1; i<arreglo.length;i++) {
			
			for(int j=i; j>0&& arreglo[j-1]>arreglo[j]; j--) {
				
				float temp= arreglo[j];
				arreglo[j]= arreglo[j-1];
				arreglo[j-1]= temp;
			}
		}return arreglo;
	}
	
	
	
	
	public ArrayList<Integer> InsertionDown(ArrayList<Integer> numbers) {
		for(int i=1; i<numbers.size();i++) {
			for(int j=i; j>0&& numbers.get(j-1)<numbers.get(j); j--) {
				Integer  actual=numbers.get(j);
				Integer  previous=numbers.get(j-1);
				Integer temp= actual;
				actual=  previous;
				previous= temp;
			}
		}
		return numbers;
	}
	
	
	 
	// QUICK SORT
     public ArrayList<Double> quickSort(ArrayList<Double> numbers) {
         
		      
				
		        
		        int length = numbers.size();
		        quickSort(numbers,0, length - 1);
				return numbers;
				
		    }
	 
 
	 private void quickSort(ArrayList<Double> numbers,int lowerIndex, int higherIndex) {
         
	        int i = lowerIndex;
	        int j = higherIndex;
	       
	        double pivot = numbers.get(lowerIndex+(higherIndex-lowerIndex)/2);

	        while (i <= j) {
	            
	            while (numbers.get(i) < pivot) {
	                i++;
	            }
	            while (numbers.get(j) > pivot) {
	                j--;
	            }
	            if (i <= j) {
	                exchangeNumbers(numbers,i, j);
	                
	                i++;
	                j--;
	            }
	        }
	       
	        if (lowerIndex < j)
	            quickSort(numbers,lowerIndex, j);
	        if (i < higherIndex)
	            quickSort(numbers, i, higherIndex);
	    }
	 
	 private void exchangeNumbers(ArrayList<Double> numbers,int i, int j) {
		 double temp = numbers.get(i);
	       numbers.set(i, numbers.get(j));
	        numbers.set(j,temp);
	    }
	 
	 //HEAP SORT
	 public void buildheap(ArrayList<Double> arr) {      
		    
		    for(int i=(arr.size()-1)/2; i>=0; i--){
		     heapify(arr,i,arr.size()-1);
		      }
		   }
		 
		   public void heapify(ArrayList<Double> arr, int i,int size) { 
		      int left = 2*i+1;
		      int right = 2*i+2;
		      int max;
		      if(left <= size && arr.get(left) > arr.get(i)){
		       max=left;
		      } else {
		       max=i;
		      }
		 
		      if(right <= size && arr.get(right) > arr.get(max)) {
		       max=right;
		      }
		      
		      if(max!=i) {
		         exchange(arr,i, max);
		         heapify(arr, max,size);
		      }
		   }

		 
		   public  void exchange(ArrayList<Double> arr,int i, int j) {
			   
		        double t = arr.get(i);
				arr.set(i,arr.get(j));
		        arr.set(j,t);
		        
		   }
		 
		   public ArrayList<Double> heapSort(ArrayList<Double> arr) {
		     
		      buildheap(arr);
		      int sizeOfHeap=arr.size()-1;
		      for(int i=sizeOfHeap; i>0; i--) {
		         exchange(arr,0, i);
		         sizeOfHeap=sizeOfHeap-1;
		         heapify(arr, 0,sizeOfHeap);
		      }
		      return arr;
		   }

	 
	 
      
	    
       public static void main(String[] args) {
    	   Principal principal = new Principal();
    	   ArrayList<Double> array = new  ArrayList<Double>();
    	   array.add(5.3);
    	   array.add((double)9);
    	   array.add(10.33);
    	   array.add((double)1);
    	   array.add(50.5);
    	   array.add(17.446799);
    	   array.add( 17.3338);
    	   array.add(3.2);
    	   array.add(2.2);
    	   array.add((double)5);
    	   
    	   
    	   System.out.println("QUICK");
    	   principal.quickSort(array);
    	   for(int i=0;i<array.size();i++) {
    		   System.out.println(array.get(i));
    	   }
    	   
    	   System.out.println("\nINSERCION");
    	   principal.InsertionUp(array);
    	   for(int i=0;i<array.size();i++) {
    		   System.out.println(array.get(i));
    	   }
    	   
    	   System.out.println("\nHEAPSORT");
    	   principal.heapSort(array);
    	   for(int i=0;i<array.size();i++) {
    		   System.out.println(array.get(i));
    	   }
    	   
    	   System.out.println("\nCON ALEATORIOS(heapsort)");
    	   ArrayList<Double> arrayAle = principal.randomInt(6,false, 1, 9);
    	   principal.heapSort(arrayAle);
    	   for(int i=0;i<arrayAle.size();i++) {
    		   System.out.println(arrayAle.get(i));
    	   }
    	   
    	   System.out.println("\n% CON INSERCION");
    	   //principal.InsertionUp(array);
    	   System.out.println("cantidad de numeros desordenados  "+principal.calculatePercent(10, 40));
    	   for(int i=0;i<principal.changeNumbers(array, 10, 40).size();i++) {
    		   System.out.println(principal.changeNumbers(array, 10, 40).get(i));
    	   }
    	   
    	   
    	   
    	   
    	   
    	   
    	   
       }
		 
		    
		   
		    
		    


	
	

}
