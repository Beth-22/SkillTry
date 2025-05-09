const express = require("express");
const {
  signupUser,
  loginUser,
  logoutUser,
  refreshToken,
  selectUserRole, // ✅ new
} = require("../controllers/authController");

const { authenticateUser } = require("../middlewares/authMiddleware");

const router = express.Router();

router.post("/signup", signupUser);
router.post("/login", loginUser);
router.post("/logout", logoutUser);
router.post("/refresh", refreshToken);
router.post("/select-role", authenticateUser, selectUserRole); // ✅ new route

module.exports = router;
