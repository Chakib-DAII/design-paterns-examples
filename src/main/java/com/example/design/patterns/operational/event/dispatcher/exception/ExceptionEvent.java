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
package com.example.design.patterns.operational.event.dispatcher.exception;

import com.example.design.patterns.operational.event.dispatcher.event.Event;

/**
 * Indicates the {@link Event} also contains information about a {@link Throwable} that occurred, triggering the event.
 *
 * Created by chakib.daii on 7/1/2021.
 */
public interface ExceptionEvent {

    /**
     * @return the throwable that caused this event to be dispatched.
     */
    Throwable getCause();

}
