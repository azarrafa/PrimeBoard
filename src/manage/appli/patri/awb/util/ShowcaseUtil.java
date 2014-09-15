/*
 * Copyright 2011-2012 PrimeFaces Extensions.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * $Id: ShowcaseUtil.java 1120 2012-04-01 00:37:49Z pavol.slany@gmail.com $
 */

package manage.appli.patri.awb.util;

import javax.faces.context.FacesContext;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * ShowcaseUtil
 *
 * @author  Pavol Slany / last modified by $Author: pavol.slany@gmail.com $
 * @version $Revision: 1120 $
 */
public class ShowcaseUtil {
    public static String getFileContent(String fullPathToFile) {
        try {
            // Finding in WEB ...
            FacesContext fc = FacesContext.getCurrentInstance();
            InputStream is = fc.getExternalContext().getResourceAsStream(fullPathToFile);
            if (is != null) return convertStreamToString(is);

            // Finding in ClassPath ...
            is = ShowcaseUtil.class.getResourceAsStream(fullPathToFile);
            if (is != null) return convertStreamToString(is);

        } catch (Exception e) {}
        return "";
    }

	private static String convertStreamToString(InputStream is) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(is));

		StringBuilder sb = new StringBuilder();

		String line = br.readLine();
		while (line != null) {
		    sb.append("\n");
			sb.append(line);
            line = br.readLine();
		}

		return sb.toString().trim();
	}
}
