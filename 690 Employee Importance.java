/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id)
    {
        /*
            1. Create map and store employee objects corresponding to id
            2. Create an empty queue
            3. Put id employee object in queue.
            4. run while loop until queue empty
            5. poll from queue and add ots subordinates.
            6. add total importance of each polled employee.
        */
        Map<Integer, Employee> map = new HashMap<>();
        for(Employee employee : employees)
            map.put(employee.id, employee);
        
        Queue<Employee> queue = new LinkedList<>();
        queue.offer(map.get(id));
        int totalImportance = 0;
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            for(int i = 0 ; i < size; i ++)
            {
                Employee current = queue.poll();
                totalImportance += current.importance;
                for(int subordinate : current.subordinates)
                    queue.offer(map.get(subordinate));
            }
            
        }
        return totalImportance;
    }
}