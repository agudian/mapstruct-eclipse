/**
 *  Copyright 2012-2016 Gunnar Morling (http://www.gunnarmorling.de/)
 *  and/or other contributors as indicated by the @authors tag. See the
 *  copyright.txt file in the distribution for a full listing of all
 *  contributors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.mapstruct.eclipse.internal.quickfix;

import java.util.List;

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;

/**
 * @author Andreas Gudian
 *
 */
public abstract class QuickFixFactory {
    /**
     * @param marker the problem marker to create a fix for
     * @return the quick fixes, or an empty list if the fix is not applicable to the given marker
     */
    public abstract List<? extends MapStructQuickFix> createQuickFix(IMarker marker);

    /**
     * @param marker the marker
     * @return the message of the marker, or an empty string in case the message cannot be retrieved
     */
    protected static String getMessage(IMarker marker) {
        try {
            return (String) marker.getAttribute( IMarker.MESSAGE );
        }
        catch ( CoreException e ) {
            return "";
        }
    }
}
