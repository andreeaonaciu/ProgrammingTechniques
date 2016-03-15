package controller;

import java.util.ArrayList;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


import models.Polynomial;

import models.Term;

public class Converter {
  public Polynomial conevertStringIntoPolynomial(String polynomial){
	  Polynomial poly=new Polynomial();
	  ArrayList<Term> terms=new ArrayList<Term>();
	  Pattern p = Pattern.compile( "(-?\\b\\d+)[xX]\\^(-?\\d+\\b)" );// sets a pattern that describes a polynomial format
	  Matcher m = p.matcher( polynomial );
	  while (m.find()) {
		  // adds to a list of term the matching between the input string and the pattern
		  terms.add(new Term(Integer.parseInt(m.group(2)),Double.parseDouble(m.group(1))));
		  
	  }
	 
	  poly.setTerms(terms);
	  return poly;
  }
}
