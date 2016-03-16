grammar SQL;
options {
	language = Java;
}
@header {
	import java.util.Hashtable;
}
@members {
	public Hashtable<String, String> t = new Hashtable();
}

eval returns [Hashtable<String, String> hash]
	:  sql_query EOF {$hash = t;}
	;
	
sql_query
	: select_statement from_statement (where_statement)?
	;
	
select_statement
	//Match case insensitivity
	: SELECT '*'			 { t.put("attribute", "*"); }
	| SELECT attribute_list 	{t.put("attribute", $attribute_list.text);}
	;
	
from_statement
	//Match case insensitivity
	: FROM table_name		{ t.put("table", $table_name.text); }
	;
	
where_statement
	//Match case insensitivity
	: WHERE attribute_name operator constant	
	{ 	
		t.put("where_attribute", $attribute_name.text); 
		t.put("where_operator", $operator.text); 
		t.put("where_constant", $constant.text);
	}
	;
	
attribute_list
	: attribute_name (',' attribute_name)*
	;
	
table_name
	: STRING_LITERAL
	;
	
attribute_name
	: STRING_LITERAL
	;
	
operator
	: '=' | '!=' | '>' | '>=' | '<' | '<=' 
	;
	
constant 
	: INTEGER 
	| '"' STRING_LITERAL '"'	
	;
	
SELECT: 'SELECT';
FROM: 'FROM';
WHERE: 'WHERE';
INTEGER : ('0'..'9')+;
STRING_LITERAL:  ('a'..'z' | 'A'..'Z' | '0'..'9')+;
WS : (' ' | '\t' | '\n' | '\r' | '\f')+  {$channel=HIDDEN;};
