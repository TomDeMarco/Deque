public class MyDeque<T> implements DequeInterface<T>{
   
    private T[] data ;
    private int front;
    private int back;
    private int size;
    private int capacity;
    private int midpoint;

    // Default constructor
    public MyDeque(int cap){

         this.data = (T[]) new Object[cap];
        this.back = 0;
        this.front = 0;
        this.size = 0;
        this.capacity= cap;
        this.midpoint = (capacity/2);
    }

   /** Adds a new entry to the front/back of this deque.
       @param newEntry  An object to be added. */
       public void addToFront(T newEntry){

        if(this.size == this.capacity){
            this.resizeDeque(this.capacity); 
        }
         if(size ==0){
            this.front = midpoint;
            this.back = midpoint;
            this.data[front]=newEntry;
            size++;

        }
      else if(front != 0){
             front--;
            this.data[front] = newEntry;
            size++;
       }
       else if( front == 0){
            front = capacity-1;
            this.data[front]=newEntry;
            size++;

       }
    }
    /*Add to logical back of deque 
    */
       public void addToBack(T newEntry){

        if(this.size == this.capacity){
            this.resizeDeque(this.capacity);       
         
        } 
         if(size == 0){
            this.front = midpoint;
            this.back = midpoint;
            this.data[back]=newEntry;
            this.size++;
        }
        else if(back != (capacity-1) ){
                back++;
                this.data[back] = newEntry;
                size++;
       }
       else if(back == (capacity-1)){
            back =0;
            this.data[back] = newEntry;
            size++;
       }
    }
       
       /** Removes and returns the front entry of this deque.
           @return  The object at the front of the deque.
           @return  null if the deque is empty before the operation. */
       public T removeFront(){
        T temp= data[front];
        data[front]= null;
        size--;
            if(front !=capacity-1){
                front++;
            }else if(front == (capacity-1)){
                front = 0;      
            }
                        return temp;


       }

        /** Removes and returns the back entry of this deque.
           @return  The object at the back of the deque.
           @return  null if the deque is empty before the operation. */
       public T removeBack(){
        T temp= data[back];
        data[back]= null;
        size--;
            if(back != 0){
                back--;
            }else if(back == 0){
                back= (capacity-1);      
            }
                        return temp;
       }
       
       /* Gets the front entry
        @return the object at the front of the deque
        */
       public T getFront(){
                T temp = data[front];
        return temp;
       }
       
       /* Gets the back entry
        @return the object at the back of the deque
        */
       public T getBack(){
            T temp = data[back];
        return temp;
       }
       
       /** Detects whether this deque is empty.
           @return  True if the deque is empty, or false otherwise. */
       public boolean isEmpty(){
               boolean result = false;
                if(size == 0){
                    result = true;

                }
                 return result;
       }
       
       /*  Removes all entries from this deque. */
       public void clear(){
        for(int i =0; i< size;i++){
            data[i] = null;
        }

        
       }
       
       /** Returns number of items currently stored in the deque.
              @return an int equal to the logical size of the deque.  */
       public int size(){

        return this.size;
       }
       
        /** Returns total capacity of the deque, counting used and unused
            locations. 
              @return an int equal to the capacity of the deque.  */ 
       public int capacity(){
            int placeholder = this.capacity;

        return placeholder;
       }
      
       // copy constructor (deep copy)
        public MyDeque(MyDeque<T> old){
            this.back = old.back;
            this.front = old.front;
            this.size = old.size;
            this.capacity = old.capacity;
  
            T[] temp = (T[]) new Object[old.capacity];
            int curr = old.front;
            

            while( curr != back ){
                temp[curr] = old.data[curr];
                if(curr == old.capacity-1 ){
                    curr = 0;
                }else if(curr != old.capacity-1){
                    curr++;
                 }

            }
            temp[curr] = old.data[curr];
            this.data = temp;
        
    }
        /* Compares two deques from logical front to logical back to check for equivalence
          @return True/False depending on the deques
         */

        public boolean equals(MyDeque<T> compareTo){
            int thisCurr = this.front;
            int compareToCurr = compareTo.front;

            if(compareTo.size != this.size ){
                    return false;
            }
            else if(this.data[this.back] != compareTo.data[compareTo.back] || this.data[this.front] != compareTo.data[compareTo.front]){
                    return false;
            }
            else{
                        
                while(thisCurr != this.back){
                    if(this.data[thisCurr] != compareTo.data[compareToCurr]){
                            return false;
                    } 
                    if(thisCurr < this.back || thisCurr> this.back && thisCurr != this.capacity-1){
                        thisCurr++;
                    }else if(thisCurr == this.capacity-1){
                        thisCurr = 0;
                    }
                    if(compareToCurr < compareTo.back || compareToCurr> compareTo.back && compareToCurr != compareTo.capacity-1 ){
                        compareToCurr++;
                    }else if(compareToCurr == compareTo.capacity-1){
                        compareToCurr = 0;

                    }

                }
            }
            return true;
        }

        /* Converts the deque to a string and prints from logical front to back
         * @return deque contents as a string
         */

        public String toString(){
            int curr = this.front;
            String result = "The Deque is: { ";
            while(curr != back ){
                result = result + " ["+ data[curr] + "] ";
                if(curr != capacity-1){
                curr++;
                }else if(curr == capacity-1){
                        curr =0;
                }
        }
        result = result + " [" +data[curr] + "]  }";
        return result;
    }

 
       /* Doubles the size of the array while maintaining the logical order of its contents
        * 
        */
       public void resizeDeque(int capacityOfOld){
        int oldCapacity = capacity;
        this.capacity = capacity + capacityOfOld;
        T[] temp = (T[]) new Object[this.capacity];
        int i =0;
        while(this.front != this.back){
                temp[i] = this.data[front];
                i++;
                if(front<oldCapacity-1){
                    front++;
                 } else if(front == oldCapacity-1){
                    front =0;
                }
        }
        temp[i] = data[front];
        this.data = temp;
        this.front = 0; 
        this.back = this.size-1;
       }
    

    
 }


