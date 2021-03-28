// Copyright (C) 2021 The Android Open Source Project
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.googlesource.gerrit.plugins.random;

import com.google.gerrit.extensions.registration.DynamicItem;
import com.google.gerrit.sshd.CommandMetaData;
import com.google.gerrit.sshd.SshCommand;
import com.google.inject.Inject;

@CommandMetaData(name = "generate", description = "Generate random number")
public class GenerateCommand extends SshCommand {
  @Inject DynamicItem<RandomApi> apiItem;

  @Override
  protected void run() throws UnloggedFailure {
    RandomApi api = apiItem.get();
    if (api == null) {
      stdout.print("api is not available\n");
    } else {
      stdout.print(String.format("random: %s\n", api.generate()));
    }
  }
}
