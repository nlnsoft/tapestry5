// Copyright 2009 The Apache Software Foundation
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package org.example.app0.pages;

import java.util.List;

import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.annotations.SessionState;
import org.apache.tapestry5.internal.hibernate.PersistedEntity;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.Request;
import org.apache.tapestry5.services.Session;
import org.example.app0.entities.User;
import org.example.app0.services.UserDAO;

public class SSOEntity 
{
    @SessionState
    @Property
    private User user;

    @Inject
    private UserDAO userDAO;
    
    @Inject
    private Request request;
    
    void onPersistEntity()
    {
        User user = new User();
        user.setFirstName("name");

        userDAO.add(user);

        this.user = user;
    }
    
    void onSetToNull()
    {
        user = null;
    }
    
    void onSetToTransient()
    {
        user = new User();
    }
    
    void onDelete()
    {
        List<User> users = userDAO.findAll();

        userDAO.delete(users.toArray(new User[0]));
        System.err.println("DELETED");
    }
    
    public String getPersistedEntityClassName()
    {
    	Session session = request.getSession(true);
    	
    	Object value = session.getAttribute("sso:"+User.class.getName());
    	
    	System.err.println("getPersistedEntityClassName(): "+value);
    	
    	return value.getClass().getName();
    }
}
