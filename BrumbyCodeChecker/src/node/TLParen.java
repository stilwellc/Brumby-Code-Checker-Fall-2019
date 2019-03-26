package lexing.node;

import lexing.analysis.*;

@SuppressWarnings("nls")
public final class TLParen extends Token
{
    public TLParen()
    {
        super.setText("(");
    }

    public TLParen(int line, int pos)
    {
        super.setText("(");
        setLine(line);
        setPos(pos);
    }

    @Override
    public Object clone()
    {
      return new TLParen(getLine(), getPos());
    }

    @Override
    public void apply(Switch sw)
    {
        ((Analysis) sw).caseTLParen(this);
    }

    @Override
    public void setText(@SuppressWarnings("unused") String text)
    {
        throw new RuntimeException("Cannot change TLParen text.");
    }
}