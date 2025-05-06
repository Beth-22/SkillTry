const express = require("express");
const { signupUser, loginUser, logoutUser, refreshToken } = require("../controllers/authController");

const router = express.Router();

router.post("/signup", signupUser);
router.post("/login", loginUser);
router.post("/logout", logoutUser);
router.post("/refresh", refreshToken); // ✅ refresh endpoint

module.exports = router;
