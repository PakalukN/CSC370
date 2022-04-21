#include <iostream>

int main () {

    int i = 0, j = 0;
    int k = (j + 13) / 27;

    while (k <= 10) {
        k = k + 1;
        i = 3 * k - 1;
    }

    std::cout << i << std::endl;

    return 0;
}
