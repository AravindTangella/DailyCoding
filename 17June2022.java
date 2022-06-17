Problem : We're given a hashmap associating each courseId key with a list of courseIds values, which represents that the prerequisites of courseId are 
          courseIds. Return a sorted ordering of courses such that we can finish all courses.

          Return null if there is no such ordering.

          For example, given {'CSC300': ['CSC100', 'CSC200'], 'CSC200': ['CSC100'], 'CSC100': []}, should return ['CSC100', 'CSC200', 'CSCS300'].
          
Similar kind of question in leetcode : There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array 
                            prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

    For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
    Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to 
    finish all courses, return an empty array.
  
  Solution : class Solution {
                //Points to an index in order[] array where current completed course should be added
                int orderIdx = 0;

                public int[] findOrder(int numCourses, int[][] prerequisites) {
                    //Stores the resultant order
                    int order[] = new int[numCourses];

                    if(prerequisites.length == 0 ) {
                        for(int i = 1; i < numCourses; i++)
                            order[i] = i;
                        return order;
                    }
                    //Mapping courses with all of its prequisites
                    Map<Integer, List<Integer>> CoursesWithPrerequisites = new HashMap<>();

                    for(int i[] : prerequisites) {
                        if(CoursesWithPrerequisites.get(i[0]) == null) {
                            List<Integer> prereqs = new ArrayList<>();
                            prereqs.add(i[1]);
                            CoursesWithPrerequisites.put(i[0], prereqs);
                        }
                        else {
                            List<Integer> prereqs = CoursesWithPrerequisites.get(i[0]);
                            prereqs.add(i[1]);
                            CoursesWithPrerequisites.put(i[0], prereqs);
                        }
                    }

                    int[] completed = new int[numCourses];//Completed courses will be marked with digit 1.

                    //It contains the path of courses we are coming though in dfs
                    List<Integer> path = new ArrayList<Integer>();

                    //For every course in the map, applying dfs on it's prerequisites until I reach a course without prerequisites
                    for(Map.Entry<Integer, List<Integer>> map : CoursesWithPrerequisites.entrySet()) {
                        int course = (int)map.getKey();           
                        if(!computeOrder(course, CoursesWithPrerequisites, path, completed, order))
                            return new int[0];
                    }

                    /*
                        There may be courses that doesn't depend on any other course and as well as no other course depends on this
                        course. As they go unvisited, adding them at the end of order array.
                     */           
                    for(int i = 0; i < completed.length; i++) {
                        if(completed[i] == 0)
                            order[orderIdx++] = i;
                    }

                    return order;
                }

                public boolean computeOrder(int node, Map<Integer, List<Integer>> CoursesWithPrerequisites, List<Integer> path,
                                             int[] completed, int[] order) {
                    if(completed[node] == 1)
                        return true;

                    if(path.contains(node))
                        return false;      

                    List<Integer> prerequisites = CoursesWithPrerequisites.get(node);

                    if(prerequisites == null) {
                        completed[node] = 1;
                        order[orderIdx++] = node;
                        return true;
                    }

                    //Adding the current node to the path
                    path.add(node);

                    for(int i = 0; i < prerequisites.size(); i++) {
                        if(!computeOrder(prerequisites.get(i), CoursesWithPrerequisites, path, completed, order))
                            return false;
                    }

                    completed[node] = 1;
                    order[orderIdx++] = node;
                    return true;
                }

            }
