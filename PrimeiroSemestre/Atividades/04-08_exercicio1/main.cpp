#include <cstdlib>
#include "cPlano.h"

using namespace std;

/*
 * 
 */
int main(int argc, char** argv) {
    cPlano obj;
    obj.lerPontos();
    cout << obj.calcularDE();
    return 0;
}

