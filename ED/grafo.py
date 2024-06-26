# author: gbiz0
# Otimization of the Dijkstra algorithm for a graph

class Grafo:
    def __init__(self, num_nos, grau_max):
        self.num_nos = num_nos
        self.grau_max = grau_max
        self.lista_arestas = [[] for _ in range(num_nos)]
        self.grau_no = [0] * num_nos

    def inserir_aresta(self, orig, dest, grafo_digrafo=True):
        if orig < 0 or orig >= self.num_nos or dest < 0 or dest >= self.num_nos:
            return False

        self.lista_arestas[orig].append(dest)
        self.grau_no[orig] += 1

        if not grafo_digrafo:
            self.inserir_aresta(dest, orig, True)
        return True

    def remover_aresta(self, orig, dest, grafo_digrafo=True):
        if orig < 0 or orig >= self.num_nos or dest < 0 or dest >= self.num_nos:
            return False

        if dest in self.lista_arestas[orig]:
            self.lista_arestas[orig].remove(dest)
            self.grau_no[orig] -= 1

            if not grafo_digrafo:
                self.remover_aresta(dest, orig, True)
            return True
        return False

    def imprimir_grafo(self):
        for i in range(self.num_nos):
            print(f"{i}: ", end="")
            for j in self.lista_arestas[i]:
                print(f"{j}, ", end="")
            print()

    def busca_profundidade(self, ini, visitado=None, cont=1):
        if visitado is None:
            visitado = [0] * self.num_nos

        visitado[ini] = cont
        for adj in self.lista_arestas[ini]:
            if not visitado[adj]:
                self.busca_profundidade(adj, visitado, cont + 1)
        return visitado

    def busca_profundidade_grafo(self, ini):
        visitado = self.busca_profundidade(ini)
        for i in range(self.num_nos):
            print(f"{i} -> {visitado[i]}")

    def busca_largura_grafo(self, ini):
        visitado = [0] * self.num_nos
        fila = [ini]
        visitado[ini] = 1
        cont = 2

        while fila:
            no = fila.pop(0)
            for adj in self.lista_arestas[no]:
                if not visitado[adj]:
                    fila.append(adj)
                    visitado[adj] = cont
                    cont += 1

        for i in range(self.num_nos):
            print(f"{i} -> {visitado[i]}")

    def procura_menor_distancia(self, vet_dist, visitado):
        menor = -1
        for i in range(self.num_nos):
            if vet_dist[i] >= 0 and not visitado[i]:
                if menor == -1 or vet_dist[i] < vet_dist[menor]:
                    menor = i
        return menor

    def menor_caminho_grafo(self, ini):
        vet_no_ant = [-1] * self.num_nos
        vet_dist = [-1] * self.num_nos
        visitado = [0] * self.num_nos
        vet_dist[ini] = 0

        for _ in range(self.num_nos):
            no = self.procura_menor_distancia(vet_dist, visitado)
            if no == -1:
                break

            visitado[no] = 1
            for adj in self.lista_arestas[no]:
                dist = vet_dist[no] + 1  
                if vet_dist[adj] < 0 or dist < vet_dist[adj]:
                    vet_dist[adj] = dist
                    vet_no_ant[adj] = no

        return vet_no_ant, vet_dist


def main():
    grafo_digrafo = True
    nN = int(input("Digite o número de nós do grafo: "))
    gM = int(input("Digite o grau máximo do grafo: "))
    gr = Grafo(nN, gM)

    while True:
        orig = int(input("Digite o nó de origem da aresta (ou -0 para parar): "))
        if orig == -0:
            break
        dest = int(input("Digite o nó de destino da aresta: "))
        gr.inserir_aresta(orig, dest, grafo_digrafo)

    print("\n----Grafo----")
    gr.imprimir_grafo()

    no_inicial = int(input("Digite o nó inicial para encontrar o menor caminho: "))
    vet_no_ant, vet_dist = gr.menor_caminho_grafo(no_inicial)

    print("\n\nMenor Caminho Dijkstra:")
    print("\nNó | Anterior | Distância")
    for i in range(nN):
        print(f"{i}:  {vet_no_ant[i]}  ->  {vet_dist[i]}")


if __name__ == "__main__":
    main()
