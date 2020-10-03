"use strict";

db.person.find();
db.person.insertOne({
  id: "ac62e7d4-c7f1-4ecc-bc83-a74553c2597e",
  name: "zero",
  jobs: ["e", "er"],
  user: {
    name: "user",
    pass: "123"
  },
  date: "04:56:45.221946"
});
db.person.updateOne({
  id: "ac62e7d4-c7f1-4ecc-bc83-a74553c2597e"
}, {
  $set: {
    id: "ac62e7d4-c7f1-4ecc-bc83-a74553c2597e",
    name: "zero",
    jobs: ["house burner", "president but die too soon"],
    user: {
      name: "user",
      pass: "123"
    },
    date: "04:56:45.221946"
  }
});
db.person.updateOne({
  id: "d768e074-7290-4a4f-abe5-573c1657e440"
}, {
  $set: {
    id: "d768e074-7290-4a4f-abe5-573c1657e440",
    name: "jack",
    jobs: ["pornstar", "also a lawyer"],
    user: {
      name: "hello-kitty",
      pass: "1234"
    },
    date: "Fri Oct 02 2020 03:19:35 GMT+0700 (+07)"
  }
});