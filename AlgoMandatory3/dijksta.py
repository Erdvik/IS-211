from heapq import heappop, heappush
from math import inf

graph = { 
        'A': [('B', 10), ('C', 5), ('D', 9999), ('E', 3), ('F', 12)],
        'B': [('C', 17), ('D', 9), ('E', 17), ('F', 12), ('A', 10)],
        'C': [('D', 35), ('E', 3), ('F', 12), ('A', 5), ('B', 17)],
        'D': [('E', 9999), ('F', 12), ('A', 9999), ('B', 9), ('C', 35)],
        'E': [('F', 12), ('A', 3), ('B', 17), ('C', 3), ('D', 9999)],
        'F': [('A', 12), ('B', 12), ('C', 12), ('D', 12), ('E', 12)]
    }


def dijkstras(graph, start):
  distances = {}
  
  for vertex in graph:
    distances[vertex] = inf
    
  distances[start] = 0
  vertices_to_explore = [(0, start)]
  
  while vertices_to_explore:
    current_distance, current_vertex = heappop(vertices_to_explore)
    
    for neighbor, edge_weight in graph[current_vertex]:
      new_distance = current_distance + edge_weight
         
      if new_distance < distances[neighbor]:
        distances[neighbor] = new_distance
        heappush(vertices_to_explore, (new_distance, neighbor))
     
  return distances

print("Graph:")
print("")
print(graph)
print("")
print("Cheapest distance to connect all locations using Dijkstra's algorithm: ")
print("")
for main_vertex in graph:
  distances = dijkstras(graph, main_vertex)
  for vertex in distances:
    print("[" + str(main_vertex) + str(vertex) + "] = " + str(distances.get(vertex)))
  
  