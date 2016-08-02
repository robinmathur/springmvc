package com.rob.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.expression.WebSecurityExpressionRoot;

public class SegmentExpressionRoot extends WebSecurityExpressionRoot {

	public SegmentExpressionRoot(Authentication a, FilterInvocation fi) {
		super(a, fi);
		System.out.println("<----------NEW OBJECT CREATED------------>");
	}

}
