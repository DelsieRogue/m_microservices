package com.mustafin.learningtask.authmicroservice.prefilter;

import com.mustafin.learningtask.authmicroservice.models.User;
import com.mustafin.learningtask.authmicroservice.repository.UserRepository;
import com.mustafin.learningtask.authmicroservice.security.SecurityUser;
import com.mustafin.learningtask.authmicroservice.security.UserDetailsServiceImpl;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.util.ZuulRuntimeException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class PreFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof SecurityUser) {
            SecurityUser userInfo = (SecurityUser) authentication.getPrincipal();
            requestContext.addZuulRequestHeader("USER_ID", userInfo.getId().toString());
            requestContext.addZuulRequestHeader("ROLE_NAME", userInfo.getRole().name());
        }
        return null;
    }
}
