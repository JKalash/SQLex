// $ANTLR 3.2 Sep 23, 2009 12:02:23 SQL.g 2014-11-27 17:53:34

	import java.util.Hashtable;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class SQLParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "SELECT", "FROM", "WHERE", "STRING_LITERAL", "INTEGER", "WS", "'*'", "','", "'='", "'!='", "'>'", "'>='", "'<'", "'<='", "'\"'"
    };
    public static final int INTEGER=8;
    public static final int WHERE=6;
    public static final int WS=9;
    public static final int STRING_LITERAL=7;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__10=10;
    public static final int FROM=5;
    public static final int EOF=-1;
    public static final int SELECT=4;

    // delegates
    // delegators


        public SQLParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public SQLParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return SQLParser.tokenNames; }
    public String getGrammarFileName() { return "SQL.g"; }


    	public Hashtable<String, String> t = new Hashtable();



    // $ANTLR start "eval"
    // SQL.g:12:1: eval returns [Hashtable<String, String> hash] : sql_query EOF ;
    public final Hashtable<String, String> eval() throws RecognitionException {
        Hashtable<String, String> hash = null;

        try {
            // SQL.g:13:2: ( sql_query EOF )
            // SQL.g:13:5: sql_query EOF
            {
            pushFollow(FOLLOW_sql_query_in_eval38);
            sql_query();

            state._fsp--;

            match(input,EOF,FOLLOW_EOF_in_eval40); 
            hash = t;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return hash;
    }
    // $ANTLR end "eval"


    // $ANTLR start "sql_query"
    // SQL.g:16:1: sql_query : select_statement from_statement ( where_statement )? ;
    public final void sql_query() throws RecognitionException {
        try {
            // SQL.g:17:2: ( select_statement from_statement ( where_statement )? )
            // SQL.g:17:4: select_statement from_statement ( where_statement )?
            {
            pushFollow(FOLLOW_select_statement_in_sql_query54);
            select_statement();

            state._fsp--;

            pushFollow(FOLLOW_from_statement_in_sql_query56);
            from_statement();

            state._fsp--;

            // SQL.g:17:36: ( where_statement )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==WHERE) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // SQL.g:17:37: where_statement
                    {
                    pushFollow(FOLLOW_where_statement_in_sql_query59);
                    where_statement();

                    state._fsp--;


                    }
                    break;

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "sql_query"


    // $ANTLR start "select_statement"
    // SQL.g:20:1: select_statement : ( SELECT '*' | SELECT attribute_list );
    public final void select_statement() throws RecognitionException {
        SQLParser.attribute_list_return attribute_list1 = null;


        try {
            // SQL.g:22:2: ( SELECT '*' | SELECT attribute_list )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==SELECT) ) {
                int LA2_1 = input.LA(2);

                if ( (LA2_1==10) ) {
                    alt2=1;
                }
                else if ( (LA2_1==STRING_LITERAL) ) {
                    alt2=2;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 2, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // SQL.g:22:4: SELECT '*'
                    {
                    match(input,SELECT,FOLLOW_SELECT_in_select_statement75); 
                    match(input,10,FOLLOW_10_in_select_statement77); 
                     t.put("attribute", "*"); 

                    }
                    break;
                case 2 :
                    // SQL.g:23:4: SELECT attribute_list
                    {
                    match(input,SELECT,FOLLOW_SELECT_in_select_statement87); 
                    pushFollow(FOLLOW_attribute_list_in_select_statement89);
                    attribute_list1=attribute_list();

                    state._fsp--;

                    t.put("attribute", (attribute_list1!=null?input.toString(attribute_list1.start,attribute_list1.stop):null));

                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "select_statement"


    // $ANTLR start "from_statement"
    // SQL.g:26:1: from_statement : FROM table_name ;
    public final void from_statement() throws RecognitionException {
        SQLParser.table_name_return table_name2 = null;


        try {
            // SQL.g:28:2: ( FROM table_name )
            // SQL.g:28:4: FROM table_name
            {
            match(input,FROM,FOLLOW_FROM_in_from_statement106); 
            pushFollow(FOLLOW_table_name_in_from_statement108);
            table_name2=table_name();

            state._fsp--;

             t.put("table", (table_name2!=null?input.toString(table_name2.start,table_name2.stop):null)); 

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "from_statement"


    // $ANTLR start "where_statement"
    // SQL.g:31:1: where_statement : WHERE attribute_name operator constant ;
    public final void where_statement() throws RecognitionException {
        SQLParser.attribute_name_return attribute_name3 = null;

        SQLParser.operator_return operator4 = null;

        SQLParser.constant_return constant5 = null;


        try {
            // SQL.g:33:2: ( WHERE attribute_name operator constant )
            // SQL.g:33:4: WHERE attribute_name operator constant
            {
            match(input,WHERE,FOLLOW_WHERE_in_where_statement125); 
            pushFollow(FOLLOW_attribute_name_in_where_statement127);
            attribute_name3=attribute_name();

            state._fsp--;

            pushFollow(FOLLOW_operator_in_where_statement129);
            operator4=operator();

            state._fsp--;

            pushFollow(FOLLOW_constant_in_where_statement131);
            constant5=constant();

            state._fsp--;

             	
            		t.put("where_attribute", (attribute_name3!=null?input.toString(attribute_name3.start,attribute_name3.stop):null)); 
            		t.put("where_operator", (operator4!=null?input.toString(operator4.start,operator4.stop):null)); 
            		t.put("where_constant", (constant5!=null?input.toString(constant5.start,constant5.stop):null));
            	

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "where_statement"

    public static class attribute_list_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "attribute_list"
    // SQL.g:41:1: attribute_list : attribute_name ( ',' attribute_name )* ;
    public final SQLParser.attribute_list_return attribute_list() throws RecognitionException {
        SQLParser.attribute_list_return retval = new SQLParser.attribute_list_return();
        retval.start = input.LT(1);

        try {
            // SQL.g:42:2: ( attribute_name ( ',' attribute_name )* )
            // SQL.g:42:4: attribute_name ( ',' attribute_name )*
            {
            pushFollow(FOLLOW_attribute_name_in_attribute_list147);
            attribute_name();

            state._fsp--;

            // SQL.g:42:19: ( ',' attribute_name )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==11) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // SQL.g:42:20: ',' attribute_name
            	    {
            	    match(input,11,FOLLOW_11_in_attribute_list150); 
            	    pushFollow(FOLLOW_attribute_name_in_attribute_list152);
            	    attribute_name();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "attribute_list"

    public static class table_name_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "table_name"
    // SQL.g:45:1: table_name : STRING_LITERAL ;
    public final SQLParser.table_name_return table_name() throws RecognitionException {
        SQLParser.table_name_return retval = new SQLParser.table_name_return();
        retval.start = input.LT(1);

        try {
            // SQL.g:46:2: ( STRING_LITERAL )
            // SQL.g:46:4: STRING_LITERAL
            {
            match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_table_name166); 

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "table_name"

    public static class attribute_name_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "attribute_name"
    // SQL.g:49:1: attribute_name : STRING_LITERAL ;
    public final SQLParser.attribute_name_return attribute_name() throws RecognitionException {
        SQLParser.attribute_name_return retval = new SQLParser.attribute_name_return();
        retval.start = input.LT(1);

        try {
            // SQL.g:50:2: ( STRING_LITERAL )
            // SQL.g:50:4: STRING_LITERAL
            {
            match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_attribute_name178); 

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "attribute_name"

    public static class operator_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "operator"
    // SQL.g:53:1: operator : ( '=' | '!=' | '>' | '>=' | '<' | '<=' );
    public final SQLParser.operator_return operator() throws RecognitionException {
        SQLParser.operator_return retval = new SQLParser.operator_return();
        retval.start = input.LT(1);

        try {
            // SQL.g:54:2: ( '=' | '!=' | '>' | '>=' | '<' | '<=' )
            // SQL.g:
            {
            if ( (input.LA(1)>=12 && input.LA(1)<=17) ) {
                input.consume();
                state.errorRecovery=false;
            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                throw mse;
            }


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "operator"

    public static class constant_return extends ParserRuleReturnScope {
    };

    // $ANTLR start "constant"
    // SQL.g:57:1: constant : ( INTEGER | '\"' STRING_LITERAL '\"' );
    public final SQLParser.constant_return constant() throws RecognitionException {
        SQLParser.constant_return retval = new SQLParser.constant_return();
        retval.start = input.LT(1);

        try {
            // SQL.g:58:2: ( INTEGER | '\"' STRING_LITERAL '\"' )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==INTEGER) ) {
                alt4=1;
            }
            else if ( (LA4_0==18) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // SQL.g:58:4: INTEGER
                    {
                    match(input,INTEGER,FOLLOW_INTEGER_in_constant224); 

                    }
                    break;
                case 2 :
                    // SQL.g:59:4: '\"' STRING_LITERAL '\"'
                    {
                    match(input,18,FOLLOW_18_in_constant230); 
                    match(input,STRING_LITERAL,FOLLOW_STRING_LITERAL_in_constant232); 
                    match(input,18,FOLLOW_18_in_constant234); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "constant"

    // Delegated rules


 

    public static final BitSet FOLLOW_sql_query_in_eval38 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_eval40 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_select_statement_in_sql_query54 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_from_statement_in_sql_query56 = new BitSet(new long[]{0x0000000000000042L});
    public static final BitSet FOLLOW_where_statement_in_sql_query59 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SELECT_in_select_statement75 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_10_in_select_statement77 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_SELECT_in_select_statement87 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_attribute_list_in_select_statement89 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FROM_in_from_statement106 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_table_name_in_from_statement108 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_WHERE_in_where_statement125 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_attribute_name_in_where_statement127 = new BitSet(new long[]{0x000000000003F000L});
    public static final BitSet FOLLOW_operator_in_where_statement129 = new BitSet(new long[]{0x0000000000040100L});
    public static final BitSet FOLLOW_constant_in_where_statement131 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_attribute_name_in_attribute_list147 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_11_in_attribute_list150 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_attribute_name_in_attribute_list152 = new BitSet(new long[]{0x0000000000000802L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_table_name166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_attribute_name178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_set_in_operator0 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INTEGER_in_constant224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_constant230 = new BitSet(new long[]{0x0000000000000080L});
    public static final BitSet FOLLOW_STRING_LITERAL_in_constant232 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_constant234 = new BitSet(new long[]{0x0000000000000002L});

}