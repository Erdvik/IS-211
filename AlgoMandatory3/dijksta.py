from heapq import heappop, heappush
from math import inf

#auth: Magnus and Kantasit

#The graph that is used in the task description, using a python dictionary
graph = { 
        'A': [('B', 10), ('C', 5), ('D', 9999), ('E', 3), ('F', 12)],
        'B': [('C', 17), ('D', 9), ('E', 17), ('F', 12), ('A', 10)],
        'C': [('D', 35), ('E', 3), ('F', 12), ('A', 5), ('B', 17)],
        'D': [('E', 9999), ('F', 12), ('A', 9999), ('B', 9), ('C', 35)],
        'E': [('F', 12), ('A', 3), ('B', 17), ('C', 3), ('D', 9999)],
        'F': [('A', 12), ('B', 12), ('C', 12), ('D', 12), ('E', 12)]
    }

#the implemenmtation of the dijkstra algorithm 
def dijkstras(graph, start): #the method takes in the graph and a start vertex
  distances = {} #a dictionary to hold the distances between the vertices
  
  for vertex in graph: 
    distances[vertex] = inf #sets the distances from the start vertex to all other vertices to infinity, since they are not yet known  
  
  distances[start] = 0 #sets the distance to the start vertex to 0 since it is the same vertex 
  vertices_to_explore = [(0, start)] #initializes a heap of vertices to explore 
  
  while vertices_to_explore: #loop that runs as long as there are still verticies not explored
    current_distance, current_vertex = heappop(vertices_to_explore) #heappop() returns the smallest item from vertexes_to_explore heap
    
    for neighbor, edge_weight in graph[current_vertex]: #checks all the neighboring vertices and distances (edge_weight)
      new_distance = current_distance + edge_weight
         
      if new_distance < distances[neighbor]: #if the new distance is smaller than the distance from the other neighbors, the distance is updated with the new distance
        distances[neighbor] = new_distance
        heappush(vertices_to_explore, (new_distance, neighbor)) #uses heappush() to push the new vertex to the vertices_to_explore heap
     
  return distances #returns the dictionary of shortest distances to the vertices in the graph from the start vertex

print("Graph:")
print("")
print(graph)
print("")
print("Cheapest distance to connect all locations using Dijkstra's algorithm: ")
print("")

#a loop that runs the dijkstras() method on all the vertecies in the graph, answering problem 1 and 2
for start_vertex in graph:
  distances = dijkstras(graph, start_vertex)
  for vertex in distances:
    print("[" + str(start_vertex) + str(vertex) + "] = " + str(distances.get(vertex)))
  
  