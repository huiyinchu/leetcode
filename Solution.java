import java.util.*;

public class Solution {
	public static class LRUCache {
		private Hashtable cache = new Hashtable();
		private LinkedList pframe = new LinkedList();
		private static int cacheSize;

		public LRUCache(int size) {
			cacheSize = size;
		}

		public void add(Object key, Object val) {
			if (cache.get(key) != null)
				pframe.remove(key);
			else
				while (cache.size() + 1 > cacheSize)
					cache.remove(pframe.removeFirst());
			pframe.addLast(key);
			cache.put(key, val);
		}

		public void get(Object key) {
			if (!cache.containsKey(key))
				System.out.println("NULL");
			else{
				pframe.remove(key);
				pframe.addLast(key);
				System.out.println(cache.get(key));
				}
		}
		
		public void peek(Object key){
			if (!cache.containsKey(key))
				System.out.println("NULL");
			System.out.println(cache.get(key));
		}

		public void getLRU() {
			LinkedList tmp = new LinkedList(pframe);
			Collections.sort(tmp);
			for(Object key: tmp){
				System.out.println(key + " " + cache.get(key));
			}
		}
	}

	public static void main(String[] argvs) {
		Scanner s = new Scanner(System.in);
		int numCommands = s.nextInt();
		Scanner s2 = new Scanner(System.in);
		String cmd = s2.nextLine();
		String[] splitCommand2 = cmd.split(" ");
		LRUCache lru = new LRUCache(Integer.parseInt(splitCommand2[1]));
		for(int i=0;i<numCommands;i++){
			Scanner sr = new Scanner(System.in);
			String command = sr.nextLine();
			String[] splitCommand = command.split(" ");
			switch(splitCommand[0]){
				case "SET":
					lru.add(splitCommand[1], splitCommand[2]);
					break;
				case "GET":
					lru.get(splitCommand[1]);
					break;
				case "PEEK":
					lru.peek(splitCommand[1]);
					break;
				case "DUMP":
					lru.getLRU();
					break;
			}
		}
	}
}
