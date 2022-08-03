module.exports = (sequelize, { DataTypes }) => {
    const Bookings = sequelize.define(
        "Bookings",
        {
            slot:{
                type:DataTypes.STRING,
                allowNull:false,
            },
            bookedOn:{
                type: DataTypes.STRING,
                allowNull: false
            },
            desc:{
                type:DataTypes.STRING,
                allowNull:false
            }
        },
        {
            sequelize,
            tableName:'bookings',
            timestamps: false,
            createdAt: false,
            updatedAt: false,
        }
    );
    return Bookings;
};