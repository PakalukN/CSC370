#include <iostream>
#include <fstream>
#include <cctype>

/* Global Declarations */
/* Variables */
int charClass;
char lexeme[100];
char nextChar;
int lexLen;
int token;
int nextToken;
std::ifstream in_fp;

/* Function Declarations */
void addChar();
void getChar();
void getNonBlank();
int lex();

/* Character Classes */
enum Character {
    LETTER = 0, DIGIT,
    UNKNOWN = 99
};

/* Token Codes */
enum Token {
    INT_LIT = 10, IDENT,
    ASSIGN_OP = 20, ADD_OP,
    SUB_OP, MULT_OP, DIV_OP,
    LEFT_PAREN, RIGHT_PAREN
};

/* Main Driver */
int main () {
    in_fp.open("front.in", std::ios::in);
    if (!in_fp)
        std::cout << "ERROR - Cannot open front.in " << std::endl;
    else {
        getChar();
        do {
            lex();
        } while (nextToken != EOF);
    }
    return 0;
    in_fp.close();
}


/* lookup */
int lookup (char ch) {
    switch (ch) {
        case '(':
            addChar();
            nextToken = LEFT_PAREN;
            break;
        case ')':
            addChar();
            nextToken = RIGHT_PAREN;
            break;
        case '+':
            addChar();
            nextToken = ADD_OP;
            break;
        case '-':
            addChar();
            nextToken = SUB_OP;
            break;
        case '*':
            addChar();
            nextToken = MULT_OP;
            break;
        case '/':
            addChar();
            nextToken = DIV_OP;
            break;
        default:
            addChar();
            nextToken = EOF;
            break;
    }
    return nextToken;
}

/* addChar */
void addChar () {
    if (lexLen <= 98) {
        lexeme[lexLen++] = nextChar;
        lexeme[lexLen] = 0;
    }
    else
        std::cout << "Error - lexeme is too long " << std::endl;
}

/* getChar */
void getChar () {
    if (in_fp >> nextChar) {
        if (std::isalpha(nextChar))
            charClass = LETTER;
        else if (std::isdigit(nextChar))
            charClass = DIGIT;
        else
            charClass = UNKNOWN;
    }
    else
        charClass = EOF;
}

/* getNonBlank */
void getNonBlank () {
    while (std::isspace(nextChar)) {
        std::cout << "This loop I guess" << std::endl;
        getChar();}
}

/* lex */
int lex () {
    lexLen = 0;
    getNonBlank();
    switch (charClass) {
        case LETTER:
            addChar();
            getChar();
            while (charClass == LETTER || charClass == DIGIT) {
                addChar();
                getChar();
            }
            nextToken = IDENT;
            break;
        case DIGIT:
            addChar();
            getChar();
            while (charClass == DIGIT) {
                addChar();
                getChar();
            }
            nextToken = INT_LIT;
            break;
        case UNKNOWN:
            lookup(nextChar);
            getChar();
            break;
        case EOF:
            nextToken = EOF;
            lexeme[0] = 'E';
            lexeme[1] = 'O';
            lexeme[2] = 'F';
            lexeme[3] = 0;
            break;
    }
    std::cout << "Next token is " << nextToken << ", ";
    std::cout << "Next lexeme is " << lexeme << std::endl;
    return nextToken;
}






















































// HAHA
