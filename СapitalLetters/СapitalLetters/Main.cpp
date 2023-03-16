#include <iostream>
#include <string>

using namespace std;

int main()
{
    cout << "Write str" << endl;
    string str;
    getline(cin, str);

    for (int i = 0; i < str.size(); i++)
    {
        if (str[i] == ' ' && str[i + 1] < 123 && str[i + 1] > 96)
            str[i + 1] = str[i + 1] - 32;
    }

    cout << "Final str" << endl << str << endl;

    system("pause");
    return 0;
}
