const express = require('express');
const { QueryTypes } = require("sequelize");
const router = express.Router();
const { Doctor, Users, Bookings, sequelize, CardioReport, EyeReport, CovidReport, KidneyReport } = require('../models/index')

// router.use((req, res, next) => {
//   setTimeout(() => {
//     next();
//   }, 2000)
// })

router.get('/', async (req, res) => {
  res.status(200).json({
    message: "Hello"
  })
});

router.post('/dr', async (req, res) => {
  try {
    let { email, password } = req.body
    let data = await Doctor.findOne({
      where: {
        email,
        password
      }
    })
    if (data == null) {
      res.status(200).json({
        message: false
      })
    } else {
      res.status(200).json({
        message: true,
        id: data.id,
        name: data.name,
        email: data.email,
        special: data.special
      })
    }
  } catch (e) {
    console.log(e)
    res.status(200).json({
      message: false
    })
  }
});

router.post('/dr/bookings', async (req, res) => {
  try {
    let { DoctorId, bookedOn } = req.body
    let data = await sequelize.query("SELECT b.id as bookingId, b.bookedOn, b.desc, u.name FROM `bookings` b, `users` u WHERE b.DoctorId =" + DoctorId + " and b.bookedOn = '" + bookedOn + "' and u.id = b.UserId", { type: QueryTypes.SELECT, raw: true });
    res.status(200).json({
      message: true,
      data: data == null ? [] : data
    })

  } catch (e) {
    console.log(e)
    res.status(200).json({
      message: false
    })
  }
});


router.post('/patient', async (req, res) => {
  try {
    let { email, password } = req.body
    let data = await Users.findOne({
      where: {
        email,
        password
      }
    })
    if (data == null) {
      res.status(200).json({
        message: false
      })
    } else {
      res.status(200).json({
        message: true,
        id: data.id,
        name: data.name,
        email: data.email,
        age: data.age
      })
    }
  } catch (e) {
    console.log(e)
    res.status(200).json({
      message: false
    })
  }
});


router.post('/patient/reg', async (req, res) => {
  try {
    let { email, password, age, name } = req.body
    let data = await Users.findOne({
      where: {
        email
      }
    })
    if (data == null) {
      await Users.create({
        email, password, age, name
      })
      res.status(200).json({
        message: true
      })
    } else {
      res.status(200).json({
        message: false
      })
    }
  } catch (e) {
    console.log(e)
    res.status(200).json({
      message: false
    })
  }
});

router.post("/getBookings", async (req, res) => {
  try {
    let { bookedOn, DoctorId } = req.body;
    let data = await Bookings.findAll({
      where: {
        bookedOn,
        DoctorId
      }
    })
    res.status(200).json({
      message: true,
      data
    })
  } catch (e) {
    console.log(e)
    res.status(200).json({
      message: false
    })
  }
})

router.post('/book', async (req, res) => {
  try {
    let { slot, bookedOn, UserId, DoctorId, desc } = req.body;
    await Bookings.create({
      slot, bookedOn, UserId, DoctorId, desc
    })
    res.status(200).json({
      message: true
    })
  } catch (e) {
    console.log(e)
    res.status(200).json({
      message: false
    })
  }
})

router.post("/user/bookings", async (req, res) => {
  try {
    let { UserId } = req.body;
    let data = await Bookings.findAll({
      where: {
        UserId
      }
    })
    res.status(200).json({
      message: true,
      data
    })
  } catch (e) {
    console.log(e)
    res.status(200).json({
      message: false
    })
  }
})

//? CardioReport,EyeReport,CovidReport,KidneyReport

router.post("/report/cardio", async (req, res) => {
  try {
    let {
      uid, name, age, gender, regDate, weight, height, riskfactor, baseBp, peakBp, baseHp, peakHp, bp, hp, medications
    } = req.body;
    await CardioReport.create({
      uid, name, age, gender, regDate, weight, height, riskfactor, baseBp, peakBp, baseHp, peakHp, bp, hp, medications
    })
    res.status(200).json({
      message: true,
    })
  } catch (e) {
    console.log(e)
    res.status(200).json({
      message: false
    })
  }
})

router.post("/report/eye", async (req, res) => {
  try {
    let { uid, name, age, gender, regDate,
      re_dist_sph, re_dist_cyl, re_near_sph, re_near_cyl, le_dist_sph, le_dist_cyl, le_near_sph, le_near_cyl, use
    } = req.body;
    await EyeReport.create({
      uid, name, age, gender, regDate, re_dist_sph, re_dist_cyl, re_near_sph, re_near_cyl, le_dist_sph, le_dist_cyl, le_near_sph, le_near_cyl, use
    })
    res.status(200).json({
      message: true,
    })
  } catch (e) {
    console.log(e)
    res.status(200).json({
      message: false
    })
  }
})

router.post("/report/covid", async (req, res) => {
  try {
    let { uid, name, age, gender, regDate, collectedDate, desc, vaccine
    } = req.body;
    await CovidReport.create({
      uid, name, age, gender, regDate, collectedDate, desc, vaccine
    })
    res.status(200).json({
      message: true,
    })
  } catch (e) {
    console.log(e)
    res.status(200).json({
      message: false
    })
  }
})

router.post("/report/kidney", async (req, res) => {
  try {
    let { uid, name, age, gender, regDate,
      glucose, wbc, rbc, egfr, ureaNitrogen, sodium, potassium, cloride
    } = req.body;
    await KidneyReport.create({
      uid, name, age, gender, regDate,
      glucose, wbc, rbc, egfr, ureaNitrogen, sodium, potassium, cloride
    })
    res.status(200).json({
      message: true,
    })
  } catch (e) {
    console.log(e)
    res.status(200).json({
      message: false
    })
  }
})

//? Search By uid CardioReport,EyeReport,CovidReport,KidneyReport

router.post("/search/Cardiology", async (req, res) => {
  try {
    let { uid } = req.body;
    let data = await CardioReport.findOne({
      where: {
        uid
      }
    })
    res.status(200).json({
      message: true,
      data: data == null ? [] : [data]
    })
  } catch (e) {
    console.log(e)
    res.status(200).json({
      message: false
    })
  }
})

router.post("/search/Eye", async (req, res) => {
  try {
    let { uid } = req.body;
    let data = await EyeReport.findOne({
      where: {
        uid
      }
    })
    res.status(200).json({
      message: true,
      data: data == null ? [] : [data]
    })
  } catch (e) {
    console.log(e)
    res.status(200).json({
      message: false
    })
  }
})

router.post("/search/Covid", async (req, res) => {
  try {
    let { uid } = req.body;
    let data = await CovidReport.findOne({
      where: {
        uid
      }
    })
    res.status(200).json({
      message: true,
      data: data == null ? [] : [data]
    })
  } catch (e) {
    console.log(e)
    res.status(200).json({
      message: false
    })
  }
})

router.post("/search/Kidney", async (req, res) => {
  try {
    let { uid } = req.body;
    let data = await KidneyReport.findOne({
      where: {
        uid
      }
    })
    res.status(200).json({
      message: true,
      data: data == null ? [] : [data]
    })
  } catch (e) {
    console.log(e)
    res.status(200).json({
      message: false
    })
  }
})

module.exports = router;

