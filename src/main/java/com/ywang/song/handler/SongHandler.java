/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ywang.song.handler;

import org.apache.commons.lang3.StringUtils;

import com.ywang.song.handler.task.AuthTask;
import com.ywang.utils.LoggerUtil;

/*
 * song
 *
 * @author apple
 *
 * @since 1.0
 */
public class SongHandler {

	/*
	 * 注册 登陆
	 */
	private static final String AUTH = "a";
	
	
	
	public static String handler(String message) {

		String result = "";
		String category;
		String param;
		String command;
		int code;
				
		String msg = message.trim();
		if (StringUtils.isEmpty(msg)) {
            return result;
        } else {
            LoggerUtil.logMsg(" Message: " + message);
        }
		
		category = msg.substring(0, 1).toLowerCase();
		command = msg.substring(0, 3);
		
		code = Integer.valueOf(msg.substring(1, 3));
        param = msg.substring(3);
		

	    switch (category) {
		case AUTH:            
            result = AuthTask.execute(code, param);
			break;
			
		default:
			break;
		}
		return command + result;
	}
}
