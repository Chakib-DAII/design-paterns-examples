/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.design.patterns.operational.event.dispatcher.type;

import com.example.design.patterns.operational.event.dispatcher.event.Event;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Enumeration containing all possible types of {@link Event}s.
 *
 * Created by chakib.daii on 7/1/2021.
 * 
 */
public interface EventType {

    String name();

    static EventType[] values() {
        return new EventType[0];
    }

    EventType[] EMPTY_ARRAY = new EventType[] {};

    /**
     * @param string
     *            the string containing a comma-separated list of event-type names
     * @return a list of EventType based on the given list.
     * @throws IllegalArgumentException
     *             when one of the given string is not a valid type name
     */
    static EventType[] getTypesFromString(String string) {
        List<EventType> result = new ArrayList<>();
        if (string != null && !string.isEmpty()) {
            String[] split = StringUtils.split(string, ",");
            for (String typeName : split) {
                boolean found = false;
                for (EventType type : values()) {
                    if (typeName.equals(type.name())) {
                        result.add(type);
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    throw new IllegalArgumentException("Invalid event-type: " + typeName);
                }
            }
        }

        return result.toArray(EMPTY_ARRAY);
    }
}
