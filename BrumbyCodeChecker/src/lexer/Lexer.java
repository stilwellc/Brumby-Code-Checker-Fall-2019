/* This file was generated by SableCC (http://www.sablecc.org/). */

package lexer;

import java.io.*;
import node.*;

@SuppressWarnings("nls")
public class Lexer
{
    protected Token token;
    protected State state = State.INITIAL;

    private IPushbackReader in;
    private int line;
    private int pos;
    private boolean cr;
    private boolean eof;
    private final StringBuffer text = new StringBuffer();

    @SuppressWarnings("unused")
    protected void filter() throws LexerException, IOException
    {
        // Do nothing
    }

    public Lexer(@SuppressWarnings("hiding") final PushbackReader in)
    {
        this.in = new IPushbackReader() {

            private PushbackReader pushbackReader = in;
            
            @Override
            public void unread(int c) throws IOException {
                pushbackReader.unread(c);
            }
            
            @Override
            public int read() throws IOException {
                return pushbackReader.read();
            }
        };
    }
 
    public Lexer(@SuppressWarnings("hiding") IPushbackReader in)
    {
        this.in = in;
    }
 
    public Token peek() throws LexerException, IOException
    {
        while(this.token == null)
        {
            this.token = getToken();
            filter();
        }

        return this.token;
    }

    public Token next() throws LexerException, IOException
    {
        while(this.token == null)
        {
            this.token = getToken();
            filter();
        }

        Token result = this.token;
        this.token = null;
        return result;
    }

    protected Token getToken() throws IOException, LexerException
    {
        int dfa_state = 0;

        int start_pos = this.pos;
        int start_line = this.line;

        int accept_state = -1;
        int accept_token = -1;
        int accept_length = -1;
        int accept_pos = -1;
        int accept_line = -1;

        @SuppressWarnings("hiding") int[][][] gotoTable = Lexer.gotoTable[this.state.id()];
        @SuppressWarnings("hiding") int[] accept = Lexer.accept[this.state.id()];
        this.text.setLength(0);

        while(true)
        {
            int c = getChar();

            if(c != -1)
            {
                switch(c)
                {
                case 10:
                    if(this.cr)
                    {
                        this.cr = false;
                    }
                    else
                    {
                        this.line++;
                        this.pos = 0;
                    }
                    break;
                case 13:
                    this.line++;
                    this.pos = 0;
                    this.cr = true;
                    break;
                default:
                    this.pos++;
                    this.cr = false;
                    break;
                }

                this.text.append((char) c);

                do
                {
                    int oldState = (dfa_state < -1) ? (-2 -dfa_state) : dfa_state;

                    dfa_state = -1;

                    int[][] tmp1 =  gotoTable[oldState];
                    int low = 0;
                    int high = tmp1.length - 1;

                    while(low <= high)
                    {
                        // int middle = (low + high) / 2;
                        int middle = (low + high) >>> 1;
                        int[] tmp2 = tmp1[middle];

                        if(c < tmp2[0])
                        {
                            high = middle - 1;
                        }
                        else if(c > tmp2[1])
                        {
                            low = middle + 1;
                        }
                        else
                        {
                            dfa_state = tmp2[2];
                            break;
                        }
                    }
                }while(dfa_state < -1);
            }
            else
            {
                dfa_state = -1;
            }

            if(dfa_state >= 0)
            {
                if(accept[dfa_state] != -1)
                {
                    accept_state = dfa_state;
                    accept_token = accept[dfa_state];
                    accept_length = this.text.length();
                    accept_pos = this.pos;
                    accept_line = this.line;
                }
            }
            else
            {
                if(accept_state != -1)
                {
                    switch(accept_token)
                    {
                    case 0:
                        {
                            @SuppressWarnings("hiding") Token token = new0(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 1:
                        {
                            @SuppressWarnings("hiding") Token token = new1(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 2:
                        {
                            @SuppressWarnings("hiding") Token token = new2(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 3:
                        {
                            @SuppressWarnings("hiding") Token token = new3(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 4:
                        {
                            @SuppressWarnings("hiding") Token token = new4(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    case 5:
                        {
                            @SuppressWarnings("hiding") Token token = new5(
                                getText(accept_length),
                                start_line + 1,
                                start_pos + 1);
                            pushBack(accept_length);
                            this.pos = accept_pos;
                            this.line = accept_line;
                            return token;
                        }
                    }
                }
                else
                {
                    if(this.text.length() > 0)
                    {
                        throw new LexerException(
                            new InvalidToken(this.text.substring(0, 1), start_line + 1, start_pos + 1),
                            "[" + (start_line + 1) + "," + (start_pos + 1) + "]" +
                            " Unknown token: " + this.text);
                    }

                    @SuppressWarnings("hiding") EOF token = new EOF(
                        start_line + 1,
                        start_pos + 1);
                    return token;
                }
            }
        }
    }

    Token new0(@SuppressWarnings("hiding") String text, @SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TKeyword(text, line, pos); }
    Token new1(@SuppressWarnings("hiding") String text, @SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TBlank(text, line, pos); }
    Token new2(@SuppressWarnings("hiding") String text, @SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TIdentifier(text, line, pos); }
    Token new3(@SuppressWarnings("hiding") String text, @SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TTraditionalComment(text, line, pos); }
    Token new4(@SuppressWarnings("hiding") String text, @SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TDocumentationComment(text, line, pos); }
    Token new5(@SuppressWarnings("hiding") String text, @SuppressWarnings("hiding") int line, @SuppressWarnings("hiding") int pos) { return new TEndOfLineComment(text, line, pos); }

    private int getChar() throws IOException
    {
        if(this.eof)
        {
            return -1;
        }

        int result = this.in.read();

        if(result == -1)
        {
            this.eof = true;
        }

        return result;
    }

    private void pushBack(int acceptLength) throws IOException
    {
        int length = this.text.length();
        for(int i = length - 1; i >= acceptLength; i--)
        {
            this.eof = false;

            this.in.unread(this.text.charAt(i));
        }
    }

    protected void unread(@SuppressWarnings("hiding") Token token) throws IOException
    {
        @SuppressWarnings("hiding") String text = token.getText();
        int length = text.length();

        for(int i = length - 1; i >= 0; i--)
        {
            this.eof = false;

            this.in.unread(text.charAt(i));
        }

        this.pos = token.getPos() - 1;
        this.line = token.getLine() - 1;
    }

    private String getText(int acceptLength)
    {
        StringBuffer s = new StringBuffer(acceptLength);
        for(int i = 0; i < acceptLength; i++)
        {
            s.append(this.text.charAt(i));
        }

        return s.toString();
    }

    private static int[][][][] gotoTable;
/*  {
        { // INITIAL
            {{9, 9, 1}, {10, 10, 2}, {12, 12, 3}, {13, 13, 4}, {32, 32, 5}, {47, 47, 6}, {65, 90, 7}, {95, 95, 8}, {97, 97, 9}, {98, 98, 10}, {99, 99, 11}, {100, 100, 12}, {101, 101, 13}, {102, 102, 14}, {103, 104, 15}, {105, 105, 16}, {106, 107, 15}, {108, 108, 17}, {109, 109, 18}, {110, 110, 19}, {111, 111, 20}, {112, 112, 21}, {113, 113, 15}, {114, 114, 22}, {115, 115, 23}, {116, 116, 24}, {117, 117, 25}, {118, 118, 26}, {119, 119, 27}, {120, 122, 15}, },
            {{9, 32, -2}, },
            {{9, 32, -2}, },
            {{9, 32, -2}, },
            {{9, 9, 1}, {10, 10, 28}, {12, 32, -2}, },
            {{9, 32, -2}, },
            {{42, 42, 29}, {47, 47, 30}, },
            {{48, 57, 31}, {65, 90, 32}, {95, 95, 33}, {97, 122, 34}, },
            {{48, 122, -9}, },
            {{48, 95, -9}, {97, 97, 34}, {98, 98, 35}, {99, 109, 34}, {110, 110, 36}, {111, 115, 34}, {116, 116, 37}, {117, 122, 34}, },
            {{48, 95, -9}, {97, 110, 34}, {111, 111, 38}, {112, 122, 34}, },
            {{48, 95, -9}, {97, 97, 39}, {98, 103, 34}, {104, 104, 40}, {105, 110, 34}, {111, 111, 41}, {112, 116, 34}, {117, 117, 42}, {118, 122, 34}, },
            {{48, 95, -9}, {97, 100, 34}, {101, 101, 43}, {102, 110, 34}, {111, 111, 44}, {112, 122, 34}, },
            {{48, 95, -9}, {97, 109, 34}, {110, 110, 45}, {111, 119, 34}, {120, 120, 46}, {121, 122, 34}, },
            {{48, 95, -9}, {97, 97, 47}, {98, 104, 34}, {105, 105, 48}, {106, 107, 34}, {108, 108, 49}, {109, 122, 34}, },
            {{48, 122, -9}, },
            {{48, 109, -15}, {110, 110, 50}, {111, 122, 34}, },
            {{48, 110, -12}, {111, 111, 51}, {112, 122, 34}, },
            {{48, 110, -12}, {111, 111, 52}, {112, 122, 34}, },
            {{48, 95, -9}, {97, 97, 53}, {98, 122, 34}, },
            {{48, 97, -11}, {98, 98, 54}, {99, 99, 55}, {100, 109, 34}, {110, 110, 56}, {111, 116, 34}, {117, 117, 57}, {118, 122, 34}, },
            {{48, 95, -9}, {97, 113, 34}, {114, 114, 58}, {115, 116, 34}, {117, 117, 59}, {118, 122, 34}, },
            {{48, 95, -9}, {97, 97, 60}, {98, 100, 34}, {101, 101, 61}, {102, 122, 34}, },
            {{48, 100, -14}, {101, 101, 62}, {102, 103, 34}, {104, 104, 63}, {105, 115, 34}, {116, 116, 64}, {117, 117, 65}, {118, 118, 34}, {119, 119, 66}, {120, 122, 34}, },
            {{48, 113, -23}, {114, 114, 67}, {115, 120, 34}, {121, 121, 68}, {122, 122, 34}, },
            {{48, 109, -15}, {110, 110, 69}, {111, 122, 34}, },
            {{48, 95, -9}, {97, 97, 70}, {98, 110, 34}, {111, 111, 71}, {112, 122, 34}, },
            {{48, 95, -9}, {97, 98, 34}, {99, 99, 72}, {100, 114, 34}, {115, 115, 73}, {116, 122, 34}, },
            {{9, 32, -2}, },
            {{0, 9, 74}, {10, 10, 75}, {11, 12, 74}, {13, 13, 76}, {14, 41, 74}, {42, 42, 77}, {43, 255, 74}, },
            {{0, 9, 78}, {10, 10, 79}, {11, 12, 78}, {13, 13, 80}, {14, 255, 78}, },
            {{48, 122, -9}, },
            {{48, 122, -9}, },
            {{48, 122, -9}, },
            {{48, 122, -9}, },
            {{48, 95, -9}, {97, 114, 34}, {115, 115, 81}, {116, 122, 34}, },
            {{48, 95, -9}, {97, 120, 34}, {121, 121, 82}, {122, 122, 34}, },
            {{48, 95, -9}, {97, 115, 34}, {116, 116, 83}, {117, 122, 34}, },
            {{48, 110, -12}, {111, 111, 84}, {112, 122, 34}, },
            {{48, 114, -37}, {115, 115, 85}, {116, 122, 34}, },
            {{48, 95, -9}, {97, 97, 86}, {98, 122, 34}, },
            {{48, 109, -15}, {110, 110, 87}, {111, 122, 34}, },
            {{48, 114, -37}, {115, 115, 88}, {116, 122, 34}, },
            {{48, 95, -9}, {97, 101, 34}, {102, 102, 89}, {103, 122, 34}, },
            {{48, 95, -9}, {97, 116, 34}, {117, 117, 90}, {118, 122, 34}, },
            {{48, 116, -46}, {117, 117, 91}, {118, 122, 34}, },
            {{48, 98, -29}, {99, 99, 92}, {100, 122, 34}, },
            {{48, 98, -29}, {99, 99, 93}, {100, 107, 34}, {108, 108, 94}, {109, 122, 34}, },
            {{48, 95, -9}, {97, 119, 34}, {120, 120, 95}, {121, 122, 34}, },
            {{48, 110, -12}, {111, 111, 96}, {112, 122, 34}, },
            {{48, 110, -12}, {111, 111, 97}, {112, 115, 34}, {116, 116, 98}, {117, 122, 34}, },
            {{48, 109, -15}, {110, 110, 99}, {111, 122, 34}, },
            {{48, 95, -9}, {97, 99, 34}, {100, 100, 100}, {101, 122, 34}, },
            {{48, 115, -39}, {116, 116, 101}, {117, 122, 34}, },
            {{48, 95, -9}, {97, 105, 34}, {106, 106, 102}, {107, 122, 34}, },
            {{48, 115, -39}, {116, 116, 103}, {117, 122, 34}, },
            {{48, 100, -14}, {101, 101, 104}, {102, 122, 34}, },
            {{48, 115, -39}, {116, 116, 105}, {117, 122, 34}, },
            {{48, 95, -9}, {97, 104, 34}, {105, 105, 106}, {106, 122, 34}, },
            {{48, 97, -11}, {98, 98, 107}, {99, 122, 34}, },
            {{48, 104, -60}, {105, 105, 108}, {106, 122, 34}, },
            {{48, 95, -9}, {97, 97, 109}, {98, 122, 34}, },
            {{48, 95, -9}, {97, 112, 34}, {113, 113, 110}, {114, 122, 34}, },
            {{48, 110, -12}, {111, 111, 111}, {112, 122, 34}, },
            {{48, 113, -23}, {114, 114, 112}, {115, 122, 34}, },
            {{48, 95, -9}, {97, 111, 34}, {112, 112, 113}, {113, 122, 34}, },
            {{48, 104, -60}, {105, 105, 114}, {106, 122, 34}, },
            {{48, 116, -46}, {117, 117, 115}, {118, 122, 34}, },
            {{48, 111, -67}, {112, 112, 116}, {113, 122, 34}, },
            {{48, 104, -60}, {105, 105, 117}, {106, 114, 34}, {115, 115, 118}, {116, 122, 34}, },
            {{48, 95, -9}, {97, 107, 34}, {108, 108, 119}, {109, 122, 34}, },
            {{48, 104, -60}, {105, 105, 120}, {106, 122, 34}, },
            {{48, 95, -9}, {97, 103, 34}, {104, 104, 121}, {105, 122, 34}, },
            {{48, 115, -39}, {116, 116, 122}, {117, 122, 34}, },
            {{0, 41, -31}, {42, 42, 123}, {43, 255, 74}, },
            {{0, 255, -76}, },
            {{0, 9, 74}, {10, 10, 124}, {11, 255, -76}, },
            {{0, 9, 125}, {10, 10, 126}, {11, 12, 125}, {13, 13, 127}, {14, 41, 125}, {42, 42, 128}, {43, 46, 125}, {47, 47, 129}, {48, 255, 125}, },
            {{0, 255, -32}, },
            {},
            {{10, 10, 130}, },
            {{48, 115, -39}, {116, 116, 131}, {117, 122, 34}, },
            {{48, 122, -9}, },
            {{48, 113, -23}, {114, 114, 132}, {115, 122, 34}, },
            {{48, 107, -72}, {108, 108, 133}, {109, 122, 34}, },
            {{48, 100, -14}, {101, 101, 134}, {102, 122, 34}, },
            {{48, 113, -23}, {114, 114, 135}, {115, 122, 34}, },
            {{48, 114, -37}, {115, 115, 136}, {116, 116, 137}, {117, 122, 34}, },
            {{48, 115, -39}, {116, 116, 138}, {117, 122, 34}, },
            {{48, 95, -9}, {97, 97, 139}, {98, 122, 34}, },
            {{48, 97, -11}, {98, 98, 140}, {99, 122, 34}, },
            {{48, 95, -9}, {97, 108, 34}, {109, 109, 141}, {110, 122, 34}, },
            {{48, 100, -14}, {101, 101, 142}, {102, 122, 34}, },
            {{48, 115, -39}, {116, 116, 143}, {117, 122, 34}, },
            {{48, 114, -37}, {115, 115, 144}, {116, 122, 34}, },
            {{48, 100, -14}, {101, 101, 145}, {102, 122, 34}, },
            {{48, 95, -9}, {97, 97, 146}, {98, 122, 34}, },
            {{48, 116, -46}, {117, 117, 147}, {118, 122, 34}, },
            {{48, 100, -14}, {101, 101, 148}, {102, 122, 34}, },
            {{48, 95, -9}, {97, 102, 34}, {103, 103, 149}, {104, 122, 34}, },
            {{48, 116, -46}, {117, 117, 150}, {118, 122, 34}, },
            {{48, 104, -60}, {105, 105, 151}, {106, 122, 34}, },
            {{48, 100, -14}, {101, 101, 152}, {102, 122, 34}, },
            {{48, 100, -14}, {101, 101, 153}, {102, 122, 34}, },
            {{48, 95, -9}, {97, 118, 34}, {119, 119, 154}, {120, 122, 34}, },
            {{48, 122, -9}, },
            {{48, 95, -9}, {97, 117, 34}, {118, 118, 155}, {119, 122, 34}, },
            {{48, 107, -72}, {108, 108, 156}, {109, 122, 34}, },
            {{48, 114, -37}, {115, 115, 157}, {116, 122, 34}, },
            {{48, 99, -54}, {100, 100, 158}, {101, 122, 34}, },
            {{48, 116, -46}, {117, 117, 159}, {118, 122, 34}, },
            {{48, 113, -23}, {114, 114, 160}, {115, 122, 34}, },
            {{48, 104, -60}, {105, 105, 161}, {106, 116, 34}, {117, 117, 162}, {118, 122, 34}, },
            {{48, 111, -67}, {112, 112, 163}, {113, 122, 34}, },
            {{48, 115, -39}, {116, 116, 164}, {117, 122, 34}, },
            {{48, 100, -14}, {101, 101, 165}, {102, 109, 34}, {110, 110, 166}, {111, 122, 34}, },
            {{48, 100, -14}, {101, 101, 167}, {102, 122, 34}, },
            {{48, 110, -12}, {111, 111, 168}, {112, 122, 34}, },
            {{48, 104, -60}, {105, 105, 169}, {106, 122, 34}, },
            {{48, 116, -46}, {117, 117, 170}, {118, 122, 34}, },
            {{48, 99, -54}, {100, 100, 171}, {101, 122, 34}, },
            {{48, 95, -9}, {97, 97, 172}, {98, 122, 34}, },
            {{48, 113, -23}, {114, 114, 173}, {115, 122, 34}, },
            {{0, 9, 174}, {10, 10, 175}, {11, 12, 174}, {13, 13, 176}, {14, 41, 174}, {42, 42, 123}, {43, 46, 174}, {47, 47, 177}, {48, 255, 174}, },
            {{0, 255, -76}, },
            {{0, 9, 178}, {10, 10, 179}, {11, 12, 178}, {13, 13, 180}, {14, 41, 178}, {42, 42, 181}, {43, 255, 178}, },
            {{0, 255, -127}, },
            {{0, 9, 178}, {10, 10, 182}, {11, 255, -127}, },
            {{0, 255, -79}, },
            {},
            {},
            {{48, 113, -23}, {114, 114, 183}, {115, 122, 34}, },
            {{48, 104, -60}, {105, 105, 184}, {106, 122, 34}, },
            {{48, 100, -14}, {101, 101, 185}, {102, 122, 34}, },
            {{48, 122, -9}, },
            {{48, 122, -9}, },
            {{48, 115, -39}, {116, 116, 186}, {117, 122, 34}, },
            {{48, 100, -14}, {101, 101, 187}, {102, 122, 34}, },
            {{48, 110, -12}, {111, 111, 188}, {112, 122, 34}, },
            {{48, 116, -46}, {117, 117, 189}, {118, 122, 34}, },
            {{48, 107, -72}, {108, 108, 190}, {109, 122, 34}, },
            {{48, 122, -9}, },
            {{48, 111, -67}, {112, 112, 191}, {113, 122, 34}, },
            {{48, 110, -12}, {111, 111, 192}, {112, 122, 34}, },
            {{48, 100, -14}, {101, 101, 193}, {102, 122, 34}, },
            {{48, 99, -54}, {100, 100, 194}, {101, 122, 34}, },
            {{48, 115, -39}, {116, 116, 195}, {117, 122, 34}, },
            {{48, 115, -39}, {116, 116, 196}, {117, 122, 34}, },
            {{48, 113, -23}, {114, 114, 197}, {115, 122, 34}, },
            {{48, 122, -9}, },
            {{48, 107, -72}, {108, 108, 198}, {109, 122, 34}, },
            {{48, 117, -108}, {118, 118, 199}, {119, 122, 34}, },
            {{48, 98, -29}, {99, 99, 200}, {100, 122, 34}, },
            {{48, 115, -39}, {116, 116, 201}, {117, 122, 34}, },
            {{48, 95, -9}, {97, 97, 202}, {98, 122, 34}, },
            {{48, 95, -9}, {97, 97, 203}, {98, 122, 34}, },
            {{48, 104, -60}, {105, 105, 204}, {106, 122, 34}, },
            {{48, 100, -14}, {101, 101, 205}, {102, 122, 34}, },
            {{48, 110, -12}, {111, 111, 206}, {112, 122, 34}, },
            {{48, 100, -14}, {101, 101, 207}, {102, 122, 34}, },
            {{48, 115, -39}, {116, 116, 208}, {117, 122, 34}, },
            {{48, 109, -15}, {110, 110, 209}, {111, 122, 34}, },
            {{48, 98, -29}, {99, 99, 210}, {100, 122, 34}, },
            {{48, 110, -12}, {111, 111, 211}, {112, 122, 34}, },
            {{48, 98, -29}, {99, 99, 212}, {100, 122, 34}, },
            {{48, 122, -9}, },
            {{48, 98, -29}, {99, 99, 213}, {100, 122, 34}, },
            {{48, 99, -54}, {100, 100, 214}, {101, 122, 34}, },
            {{48, 109, -15}, {110, 110, 215}, {111, 122, 34}, },
            {{48, 102, -101}, {103, 103, 216}, {104, 122, 34}, },
            {{48, 100, -14}, {101, 101, 217}, {102, 122, 34}, },
            {{48, 122, -9}, },
            {{48, 113, -23}, {114, 114, 218}, {115, 122, 34}, },
            {{48, 104, -60}, {105, 105, 219}, {106, 122, 34}, },
            {{0, 9, 220}, {10, 10, 221}, {11, 12, 220}, {13, 13, 222}, {14, 41, 220}, {42, 42, 223}, {43, 255, 220}, },
            {{0, 255, -176}, },
            {{0, 9, 220}, {10, 10, 224}, {11, 255, -176}, },
            {},
            {{0, 255, -127}, },
            {{0, 255, -127}, },
            {{0, 9, 178}, {10, 10, 225}, {11, 255, -127}, },
            {{0, 41, -79}, {42, 42, 181}, {43, 255, -79}, },
            {{0, 255, -127}, },
            {{48, 95, -9}, {97, 97, 226}, {98, 122, 34}, },
            {{48, 97, -11}, {98, 98, 227}, {99, 122, 34}, },
            {{48, 95, -9}, {97, 97, 228}, {98, 122, 34}, },
            {{48, 122, -9}, },
            {{48, 119, -50}, {120, 120, 229}, {121, 122, 34}, },
            {{48, 108, -93}, {109, 109, 230}, {110, 122, 34}, },
            {{48, 107, -72}, {108, 108, 231}, {109, 122, 34}, },
            {{48, 100, -14}, {101, 101, 232}, {102, 122, 34}, },
            {{48, 115, -39}, {116, 116, 233}, {117, 122, 34}, },
            {{48, 113, -23}, {114, 114, 234}, {115, 122, 34}, },
            {{48, 122, -9}, },
            {{48, 122, -9}, },
            {{48, 122, -9}, },
            {{48, 122, -9}, },
            {{48, 101, -45}, {102, 102, 235}, {103, 122, 34}, },
            {{48, 100, -14}, {101, 101, 236}, {102, 122, 34}, },
            {{48, 100, -14}, {101, 101, 237}, {102, 122, 34}, },
            {{48, 115, -39}, {116, 116, 238}, {117, 122, 34}, },
            {{48, 122, -9}, },
            {{48, 120, -38}, {121, 121, 239}, {122, 122, 34}, },
            {{48, 115, -39}, {116, 116, 240}, {117, 122, 34}, },
            {{48, 98, -29}, {99, 99, 241}, {100, 122, 34}, },
            {{48, 114, -37}, {115, 115, 242}, {116, 122, 34}, },
            {{48, 109, -15}, {110, 110, 243}, {111, 122, 34}, },
            {{48, 109, -15}, {110, 110, 244}, {111, 122, 34}, },
            {{48, 122, -9}, },
            {{48, 102, -101}, {103, 103, 245}, {104, 122, 34}, },
            {{48, 115, -39}, {116, 116, 246}, {117, 122, 34}, },
            {{48, 113, -23}, {114, 114, 247}, {115, 122, 34}, },
            {{48, 103, -74}, {104, 104, 248}, {105, 122, 34}, },
            {{48, 95, -9}, {97, 97, 249}, {98, 122, 34}, },
            {{48, 100, -14}, {101, 101, 250}, {102, 122, 34}, },
            {{48, 122, -9}, },
            {{48, 109, -15}, {110, 110, 251}, {111, 122, 34}, },
            {{48, 97, -11}, {98, 98, 252}, {99, 115, 34}, {116, 116, 253}, {117, 122, 34}, },
            {{48, 122, -9}, },
            {{48, 109, -15}, {110, 110, 254}, {111, 122, 34}, },
            {{0, 255, -176}, },
            {{0, 255, -176}, },
            {{0, 9, 220}, {10, 10, 255}, {11, 255, -176}, },
            {{0, 41, -125}, {42, 42, 223}, {43, 255, -125}, },
            {{0, 255, -176}, },
            {{0, 255, -127}, },
            {{48, 98, -29}, {99, 99, 256}, {100, 122, 34}, },
            {{48, 116, -46}, {117, 117, 257}, {118, 122, 34}, },
            {{48, 109, -15}, {110, 110, 258}, {111, 122, 34}, },
            {{48, 115, -39}, {116, 116, 259}, {117, 122, 34}, },
            {{48, 122, -9}, },
            {{48, 115, -39}, {116, 116, 260}, {117, 122, 34}, },
            {{48, 122, -9}, },
            {{48, 104, -60}, {105, 105, 261}, {106, 122, 34}, },
            {{48, 120, -38}, {121, 121, 262}, {122, 122, 34}, },
            {{48, 95, -9}, {97, 97, 263}, {98, 122, 34}, },
            {{48, 122, -9}, },
            {{48, 122, -9}, },
            {{48, 122, -9}, },
            {{48, 122, -9}, },
            {{48, 100, -14}, {101, 101, 264}, {102, 122, 34}, },
            {{48, 122, -9}, },
            {{48, 122, -9}, },
            {{48, 107, -72}, {108, 108, 265}, {109, 122, 34}, },
            {{48, 98, -29}, {99, 99, 266}, {100, 122, 34}, },
            {{48, 122, -9}, },
            {{48, 122, -9}, },
            {{48, 115, -39}, {116, 116, 267}, {117, 122, 34}, },
            {{48, 122, -9}, },
            {{48, 115, -39}, {116, 116, 268}, {117, 122, 34}, },
            {{48, 101, -45}, {102, 102, 269}, {103, 122, 34}, },
            {{48, 100, -14}, {101, 101, 270}, {102, 122, 34}, },
            {{48, 95, -9}, {97, 97, 271}, {98, 122, 34}, },
            {{48, 120, -38}, {121, 121, 272}, {122, 122, 34}, },
            {{48, 102, -101}, {103, 103, 273}, {104, 122, 34}, },
            {{0, 255, -176}, },
            {{48, 115, -39}, {116, 116, 274}, {117, 122, 34}, },
            {{48, 115, -39}, {116, 116, 275}, {117, 122, 34}, },
            {{48, 122, -9}, },
            {{48, 122, -9}, },
            {{48, 122, -9}, },
            {{48, 110, -12}, {111, 111, 276}, {112, 122, 34}, },
            {{48, 122, -9}, },
            {{48, 98, -29}, {99, 99, 277}, {100, 122, 34}, },
            {{48, 122, -9}, },
            {{48, 120, -38}, {121, 121, 278}, {122, 122, 34}, },
            {{48, 100, -14}, {101, 101, 279}, {102, 122, 34}, },
            {{48, 114, -37}, {115, 115, 280}, {116, 122, 34}, },
            {{48, 95, -9}, {97, 97, 281}, {98, 122, 34}, },
            {{48, 122, -9}, },
            {{48, 99, -54}, {100, 100, 282}, {101, 122, 34}, },
            {{48, 114, -37}, {115, 115, 283}, {116, 122, 34}, },
            {{48, 111, -67}, {112, 112, 284}, {113, 122, 34}, },
            {{48, 122, -9}, },
            {{48, 122, -9}, },
            {{48, 100, -14}, {101, 101, 285}, {102, 122, 34}, },
            {{48, 109, -15}, {110, 110, 286}, {111, 122, 34}, },
            {{48, 100, -14}, {101, 101, 287}, {102, 122, 34}, },
            {{48, 122, -9}, },
            {{48, 122, -9}, },
            {{48, 122, -9}, },
            {{48, 97, -11}, {98, 98, 288}, {99, 122, 34}, },
            {{48, 122, -9}, },
            {{48, 100, -14}, {101, 101, 289}, {102, 122, 34}, },
            {{48, 100, -14}, {101, 101, 290}, {102, 122, 34}, },
            {{48, 122, -9}, },
            {{48, 122, -9}, },
            {{48, 122, -9}, },
            {{48, 107, -72}, {108, 108, 291}, {109, 122, 34}, },
            {{48, 122, -9}, },
            {{48, 122, -9}, },
            {{48, 100, -14}, {101, 101, 292}, {102, 122, 34}, },
            {{48, 122, -9}, },
        }
    };*/

    private static int[][] accept;
/*  {
        // INITIAL
        {1, 1, 1, 1, 1, 1, -1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 1, -1, 5, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, -1, -1, -1, -1, 5, 5, 5, 2, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, -1, -1, -1, -1, -1, -1, 4, 5, 2, 2, 2, 0, 0, 2, 2, 2, 2, 2, 0, 2, 2, 2, 2, 2, 2, 2, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 2, 2, 2, 2, 2, 0, 2, 2, -1, -1, -1, 3, -1, -1, -1, -1, -1, 2, 2, 2, 0, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 2, 2, 2, 2, 0, 2, 2, 2, 2, 2, 2, 0, 2, 2, 2, 2, 2, 2, 0, 2, 2, 0, 2, -1, -1, -1, -1, -1, -1, 2, 2, 2, 2, 0, 2, 0, 2, 2, 2, 0, 0, 0, 0, 2, 0, 0, 2, 2, 0, 0, 2, 0, 2, 2, 2, 2, 2, 2, -1, 2, 2, 0, 0, 0, 2, 0, 2, 0, 2, 2, 2, 2, 0, 2, 2, 2, 0, 0, 2, 2, 2, 0, 0, 0, 2, 0, 2, 2, 0, 0, 0, 2, 0, 0, 2, 0, },

    };*/

    public static class State
    {
        public final static State INITIAL = new State(0);

        private int id;

        private State(@SuppressWarnings("hiding") int id)
        {
            this.id = id;
        }

        public int id()
        {
            return this.id;
        }
    }

    static 
    {
        try
        {
            DataInputStream s = new DataInputStream(
                new BufferedInputStream(
                Lexer.class.getResourceAsStream("lexer.dat")));

            // read gotoTable
            int length = s.readInt();
            gotoTable = new int[length][][][];
            for(int i = 0; i < gotoTable.length; i++)
            {
                length = s.readInt();
                gotoTable[i] = new int[length][][];
                for(int j = 0; j < gotoTable[i].length; j++)
                {
                    length = s.readInt();
                    gotoTable[i][j] = new int[length][3];
                    for(int k = 0; k < gotoTable[i][j].length; k++)
                    {
                        for(int l = 0; l < 3; l++)
                        {
                            gotoTable[i][j][k][l] = s.readInt();
                        }
                    }
                }
            }

            // read accept
            length = s.readInt();
            accept = new int[length][];
            for(int i = 0; i < accept.length; i++)
            {
                length = s.readInt();
                accept[i] = new int[length];
                for(int j = 0; j < accept[i].length; j++)
                {
                    accept[i][j] = s.readInt();
                }
            }

            s.close();
        }
        catch(Exception e)
        {
            throw new RuntimeException("The file \"lexer.dat\" is either missing or corrupted.");
        }
    }
}