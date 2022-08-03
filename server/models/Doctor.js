module.exports = (sequelize, { DataTypes }) => {
    const Doctor = sequelize.define(
        "Doctor",
        {
            name: {
                type: DataTypes.STRING,
                allowNull: false,
            },
            email: {
                type: DataTypes.STRING,
                allowNull: false,
            },
            password: {
                type: DataTypes.STRING,
                allowNull: false,
            },
            special:{
                type:DataTypes.STRING,
                allowNull:false
            },
        },
        {
            sequelize,
            tableName:'doctor',
            timestamps: false,
            createdAt: false,
            updatedAt: false,
        }
    );
    return Doctor;
};