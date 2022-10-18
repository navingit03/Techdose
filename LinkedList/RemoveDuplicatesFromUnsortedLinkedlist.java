//Remove duplicates from an unsorted linked list
//Using hashset
//TC: o(n) SC: o(n)
static void removeDuplicate(node head)
	{
		HashSet<Integer> hash=new HashSet<>(); //to find duplicate element
      	node prev=null;
        node curr=head;
        while(curr!=null)
        {
          int data=curr.val;
          if(hash.contains(data)) //if curr.val already in hash the prev.next=curr.next
          {
            prev.next=curr.next;
          }
          else
          {
            hash.add(data); //if not already in hash adding the value
            prev=curr; //moving prev
          }
        curr=curr.next; //curr jump one step everytime
        }
	}
